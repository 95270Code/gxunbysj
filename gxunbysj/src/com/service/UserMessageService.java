package com.service;

public interface UserMessageService {
	public String getAllUserMessage(String first,String pageSize,String searchId,String searchName,String date_from,String date_to);
	public int getCounNumber(String sqlAppendAndLimit);
	public boolean saveUser(String s_id,String s_name,String s_password,
			String s_sex,String s_academy,String s_major,String s_class,String s_grade);
	public boolean updateUser(String s_id,String s_name,String s_password,
			String s_sex,String s_academy,String s_major,String s_class,String s_grade);
	
	public boolean deleteUser(String s_id);
	
	public boolean updatePassword(String s_id,String newpassword);
}
