package com.service.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.mapper.UserRowMapper;
import com.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public User doLoginGetUser(String username, String password) {
		String sql = "select * from student_info where student_id =? and student_password=?";
		try{
			User user = jdbcTemplate.queryForObject(sql, new Object[]{username,password},new UserRowMapper());
			return user;
		}catch (Exception e) {
			System.out.println("数据库无此数据");
			return null;
		}
		
	}

}
