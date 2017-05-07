package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.entity.User;

public class UserRowMapper implements RowMapper<User>{
	
	@Override
	public User mapRow(ResultSet rs, int i) throws SQLException {
		User user = new User();
		user.setS_id(rs.getString("student_id"));
		user.setS_name(rs.getString("student_name"));
		user.setS_academy(rs.getString("student_academy"));
		user.setS_birthday(rs.getTimestamp("student_birthday"));
		user.setS_card(rs.getString("student_card"));
		user.setS_grade(rs.getString("student_grade"));
		user.setS_major(rs.getString("student_major"));
		user.setS_nation(rs.getString("student_nation"));
		user.setS_password(rs.getString("student_password"));
		user.setS_phone(rs.getString("student_phone"));
		user.setS_sex(rs.getString("student_sex"));
		user.setS_class(rs.getString("student_class"));
		user.setUpdate_time(rs.getTimestamp("update_time"));
		user.setQx(rs.getInt("qx"));
		return user;
	}

}
