package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.GgService;

@Controller
@RequestMapping("/gonggao")
public class GgController {
	@Resource
	private GgService ggService;
	
	public void setGgService(GgService ggService) {
		this.ggService = ggService;
	}

	@RequestMapping(value="/ggShowData",method=RequestMethod.POST)
	@ResponseBody
	public String ggShowData(
		   @RequestParam(value = "page",required=true)String page,  //�ڼ�ҳ
		   @RequestParam(value = "rows",required=true)String rows,  //ÿҳ��ʾ������
		   @RequestParam(value = "searchName",required=false)String searchName, // ����������
		   @RequestParam(value = "date_from",required=false)String date_from,  //ʱ����
		   @RequestParam(value = "date_to",required=false)String date_to,      //ʱ����
		   @RequestParam(value = "searchId",required=false)String searchId) { //��ѧ������
		//����service��������json����
		String json = ggService.getAllgg(page,rows,searchId,searchName,date_from,date_to); 
		return json;
	}
}
