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
		   @RequestParam(value = "page",required=true)String page,  //第几页
		   @RequestParam(value = "rows",required=true)String rows,  //每页显示的条数
		   @RequestParam(value = "searchName",required=false)String searchName, // 搜索的姓名
		   @RequestParam(value = "date_from",required=false)String date_from,  //时间起
		   @RequestParam(value = "date_to",required=false)String date_to,      //时间终
		   @RequestParam(value = "searchId",required=false)String searchId) { //按学号搜索
		//调用service方法返回json数据
		String json = ggService.getAllgg(page,rows,searchId,searchName,date_from,date_to); 
		return json;
	}
}
