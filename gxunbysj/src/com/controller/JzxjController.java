package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Gjlzjxjsqb;
import com.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.JzxjService;
import com.util.AddNumber;
import com.util.DateChange;
import com.util.RedomPID;

@Controller
@RequestMapping("/jzxj")
/**
 * ����ѧ�������
 * @author Administrator
 *
 */
public class JzxjController {
	@Resource
	private JzxjService jzxjService;

	public void setJzxjService(JzxjService jzxjService) {
		this.jzxjService = jzxjService;
	}
	/**
	 * �ύ���
	 * @param gjlzjxjsqb
	 * @return
	 */
	@RequestMapping("/submitSqb")
	@ResponseBody
	public String submitSqb(Gjlzjxjsqb gjlzjxjsqb,
			@RequestParam(value = "csnyString",required=false)String csnyString,
			@RequestParam(value = "sfqrtj",required=false)String sfqrtj){
		Date date = DateChange.changeDate(csnyString);
		gjlzjxjsqb.setCsny(date);
		gjlzjxjsqb.setSfqrtj(sfqrtj);
		String sqbbh = jzxjService.selectLastOne();
		String sqbbhIncrease = AddNumber.increaseNumber(sqbbh);
		boolean flag = jzxjService.submitForm(gjlzjxjsqb,sqbbhIncrease);
		return flag+","+sqbbhIncrease;
	}
	
	/**
	 * ������
	 * @param gjlzjxjsqb
	 * @return
	 */
	@RequestMapping("/submitSave")
	@ResponseBody
	public String saveSqb(Gjlzjxjsqb gjlzjxjsqb,
			@RequestParam(value = "csnyString",required=false)String csnyString,
			@RequestParam(value = "sqbbh",required=false)String sqbbh,
			@RequestParam(value = "sfqrtj",required=false)String sfqrtj){
 		Date date = DateChange.changeDate(csnyString);
		gjlzjxjsqb.setCsny(date);
		String sqbbhString = sqbbh;
		boolean flag = jzxjService.updateForm(gjlzjxjsqb,sqbbhString,sfqrtj);
		return flag+"";
		
	}
	
	/**
	 * ��ѯ�����
	 * @return
	 */
	@RequestMapping("/submitQuery")
	@ResponseBody
	public String querySqb(HttpSession session,
			@RequestParam(value = "page",required=false)String page,
			@RequestParam(value = "rows",required=false)String rows,
			@RequestParam(value = "searchXh",required=false)String xh,
			@RequestParam(value = "searchXm",required=false)String xm,
			@RequestParam(value = "date_from",required=false)String date_from,
			@RequestParam(value = "date_to",required=false)String date_to,
			@RequestParam(value = "sqblx",required=false)String type,
			@RequestParam(value="sfqrtj",required=false)String sfqrtj,
			@RequestParam(value="bjyj",required=false)String bjyj,
			@RequestParam(value="xyyj",required=false)String xyyj){
		
		if(type==null)
			type="gjlzjxjsqb";
		User user = (User) session.getAttribute("user");
		String json ="";
		String zy = "";
		String xy ="";
		String nj ="";
		//sfqrtj = ""; //�Ƿ�ȷ���ύ --ѧ��
		//bjyj ="";	//�༶��� --�༶
		if(user!=null){
			//1.ѧ����2.�༶����Ա��3.ѧԺ����Ա��4.ϵͳ����Ա
			int i = user.getQx(); //��ȡȨ��
			switch(i){
			case 1:
				xh = user.getS_id();
				json = jzxjService.queryForm(type,xh,xm,date_from,date_to,page,rows,zy,xy,nj,sfqrtj,bjyj,xyyj);
				break;
			case 2:
				zy = user.getS_major();
				xy = user.getS_academy();
				nj = user.getS_grade();
				sfqrtj ="Y";
				json = jzxjService.queryForm(type,xh,xm,date_from,date_to,page,rows,zy,xy,nj,sfqrtj,bjyj,xyyj);
				break;
			case 3:
				sfqrtj ="Y";
				bjyj="Y";
				json = jzxjService.queryForm(type,xh,xm,date_from,date_to,page,rows,zy,xy,nj,sfqrtj,bjyj,xyyj);
				break;
			case 4:
				break;			
			}
			
		}
		
		return json;
	}
	
	
	
	/**
	 * ͨ�������ı�Ų�ѯ
	 * @param sqbbh
	 * @param type
	 * @return
	 */
	@RequestMapping("/queryObjectBysqbbh")
	@ResponseBody
	public String queryObjectBysqbbh(
			@RequestParam(value = "sqbbh",required=false)String sqbbh,
			@RequestParam(value = "sqblx",required=false)String type,
			HttpSession session){
		Gjlzjxjsqb g = jzxjService.getGjlzjxjsqbBySqbbh(sqbbh, type);
		Gson gson = new GsonBuilder()  
				  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
				  .create();
		session.setAttribute("sqb", g);
		String json = gson.toJson(g);
		return json;
	}
	
	
	/**
	 * �༶�Ƽ����
	 * @param sqbbh
	 * @param type
	 * @param bjyj
	 * @param bjtjyj
	 * @return
	 */
	@RequestMapping("/submitBjtjyj")
	@ResponseBody
	public String submitBjtjyj(
		 @RequestParam(value = "sqbbh",required=false)String sqbbh,
		 @RequestParam(value = "sqblx",required=false)String type,
		 @RequestParam(value="bjyj",required=false)String bjyj,
		 @RequestParam(value="bjtjyj",required=false)String bjtjyj){
		
		boolean flag = jzxjService.bjyjAdd(sqbbh, type, bjyj, bjtjyj);		
		return flag+"";	
	}
	
	
	/**
	 * ѧԺ������
	 * @param sqbbh
	 * @param type
	 * @param xyyj
	 * @param xyshyj
	 * @return
	 */
	@RequestMapping("/submitXyShyj")
	@ResponseBody
	public String submitXyShyj(
			@RequestParam(value = "sqbbh",required=false)String sqbbh,
			@RequestParam(value = "sqblx",required=false)String type,
			@RequestParam(value="xyyj",required=false)String xyyj,
			@RequestParam(value="xyshyj",required=false)String xyshyj){
		boolean flag = jzxjService.xyyjAdd(sqbbh, type, xyyj, xyshyj);
		return flag+"";
		
	}
	
	
	/**
	 * �ļ��ϴ�
	 * @param file
	 * @param a
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upload")
	@ResponseBody
    public String upload(
    		@RequestParam(value = "file_upload", required = false) MultipartFile file,
    		@RequestParam(value = "bh", required = false) String sqbbh,
    		@RequestParam(value = "type", required = false) String type,
    		HttpServletRequest request) {  
        //String path = request.getServletContext().getRealPath("/")+"images";
        String ss[] = (file.getOriginalFilename()).split("\\.");
        if(ss.length>=2){
        	String path = "d:/images";
            String fileName = RedomPID.createPID()+"."+ss[ss.length-1];
            System.out.println(path);  
            File targetFile = new File(path, fileName);  
            if(!targetFile.exists()){  
                targetFile.mkdirs();  
            }  
            //����  
            try {  
                file.transferTo(targetFile);
                jzxjService.insertImgPath(type, sqbbh,path+"/"+fileName); //�������ݿ�·��
            } catch (Exception e) {  
                e.printStackTrace();
                return "false";
            } 
            return "true";
        }
        return "false";
    } 
	
	
	/**
	 * ��ȡͼƬ��Ϣ
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value="/lookImage")
    @ResponseBody 
    public void lookImage(@RequestParam(value = "sqbbh", required = false) String sqbbh,
    		@RequestParam(value = "sqblx", required = false) String sqblx,
    		HttpServletRequest request,HttpServletResponse response){   
		String filePath = jzxjService.getSqbFilePath(sqblx, sqbbh);		
        File file = new File(filePath);
        try {
        	byte[] buffer = FileUtils.readFileToByteArray(file);
        	OutputStream os = response.getOutputStream(); 
        	os.write(buffer);
		} catch (IOException e) {			
			e.printStackTrace();
		}
         
    }
}
