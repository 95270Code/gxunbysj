package com.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.LoginService;
import com.service.UserMessageService;

@Controller
@RequestMapping("/user")
public class UserMessageController {
	@Resource
	private UserMessageService userMessageService;
	
	public void setUserMessageService(UserMessageService userMessageService) {
		this.userMessageService = userMessageService;
	}
	
	@Resource
	private LoginService LoginService;

	public void setLoginService(LoginService loginService) {
		LoginService = loginService;
	}

	@RequestMapping("/showUserList")
	public ModelAndView doLogin(ModelAndView model){

		model.setViewName("/page/user/1success.jsp");
		return model;
	}
	
	/**
	 * 查询所有的用户信息
	 */
	@RequestMapping(value="/show",method=RequestMethod.POST)
	@ResponseBody
	public String userShowData(
		   @RequestParam(value = "page",required=true)String page,  //第几页
		   @RequestParam(value = "rows",required=true)String rows,  //每页显示的条数
		   @RequestParam(value = "searchName",required=false)String searchName, // 搜索的姓名
		   @RequestParam(value = "date_from",required=false)String date_from,  //时间起
		   @RequestParam(value = "date_to",required=false)String date_to,      //时间终
		   @RequestParam(value = "searchId",required=false)String searchId) { //按学号搜索
		//调用service方法返回json数据
		String json = userMessageService.getAllUserMessage(page,rows,searchId,searchName,date_from,date_to); 
		return json;
	}
	
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	@ResponseBody
	public String saveUser(
			@RequestParam(value = "s_id",required=false)String s_id,
			@RequestParam(value = "s_name",required=false)String s_name,
			@RequestParam(value = "s_password",required=false)String s_password,
			@RequestParam(value = "s_sex",required=false)String s_sex,
			@RequestParam(value = "s_academy",required=false)String s_academy,
			@RequestParam(value = "s_major",required=false)String s_major,
			@RequestParam(value = "s_class",required=false)String s_class,
			@RequestParam(value = "s_grade",required=false)String s_grade,
			@RequestParam(value = "newOrEdit",required=false)String newOrEdit){
		boolean flag = false;
		if(newOrEdit!=null&&newOrEdit.equals("new")){
			flag = userMessageService.saveUser(s_id,s_name,s_password,s_sex,s_academy,s_major, s_class, s_grade);
		}else if(newOrEdit!=null&&newOrEdit.equals("edit")){
			flag = userMessageService.updateUser(s_id,s_name,s_password,s_sex,s_academy,s_major, s_class, s_grade);
		}		
		return flag+"";	
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	@ResponseBody
	public String deleteUser(@RequestParam(value = "s_id",required=false)String s_id){	
		boolean flag = userMessageService.deleteUser(s_id);
		return flag+"";	
	}
	
	
	@RequestMapping(value="/modifyPassword",method=RequestMethod.POST)
	@ResponseBody
	public String modifyPassword(HttpSession session,
			@RequestParam(value = "newpassword",required=false)String newpassword,
			@RequestParam(value = "oldpassword",required=false)String oldpassword){
		if(session.getAttribute("user")!=null){
			User user = (User) session.getAttribute("user");
			String oldpass = user.getS_password();
			String s_id = user.getS_id();
			if(oldpassword.equals(oldpass)){
				boolean f = userMessageService.updatePassword(s_id, newpassword);
				if(f){
					return f+"1";	
				}else{
					return "false2"; //数据库出错
				}											
			}else{
				return "false3"; //初始密码错误
			}
		}
			
		return "false4"; //服务器出错		
	}
	
	
	@RequestMapping(value="/getPersonMsg")
	@ResponseBody
	public String getPersonMsg(HttpSession session){
		User user = (User) session.getAttribute("user");
		User u = LoginService.doLoginGetUser(user.getS_id(), user.getS_password());
		Gson gson = new GsonBuilder()  
				  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
				  .create();
		String json = gson.toJson(u);
		return json;
	}
}
