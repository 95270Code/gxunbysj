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
import com.service.LoginService;


@Controller
@RequestMapping("/login")
public class LoginCotroller {
	@Resource
	private LoginService LoginService;

	public void setLoginService(LoginService loginService) {
		LoginService = loginService;
	}
	
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	@ResponseBody
	public String doLogin(
			HttpSession session,
			@RequestParam(value = "username",required=false)String username,
			@RequestParam(value = "password",required=false)String password){
		String result = "false";
		User user = LoginService.doLoginGetUser(username, password);
		if(user!=null){
			session.setAttribute("user", user);
			result = "true";
			return result;
		}
		return result;	
	}
	
	@RequestMapping("/goIndex")
	public ModelAndView goIndex(ModelAndView model){
		model.setViewName("/index.jsp");
		return model;	
	}
	
	@RequestMapping("/doLogout")
	public ModelAndView doLogout(HttpSession session,ModelAndView model){
		if(session!=null){
			session.invalidate();
		}
		model.setViewName("/login.jsp");
		return model;
	}
}
