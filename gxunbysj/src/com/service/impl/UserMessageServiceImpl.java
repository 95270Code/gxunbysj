package com.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapper.ChangeCode;
import com.mapper.UserRowMapper;
import com.service.UserMessageService;

@Service("userMessageService")
public class UserMessageServiceImpl implements UserMessageService{

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Resource(name="changeCode")
	private ChangeCode changeCode;
	public void setChangeCode(ChangeCode changeCode) {
		this.changeCode = changeCode;
	}


	/**
	 * 点击进入页面后执行的方法，点击搜索执行的方法
	 */
	@Override
	public String getAllUserMessage(String page,String rows,String searchId,String searchName,String date_from,String date_to) {
		int number1 = Integer.parseInt(page);  //第几页
		int number2 = Integer.parseInt(rows);  //每页显示多少条记录
		int first = number2*(number1-1);  //从数据库的哪一条开始查
		StringBuffer sqlBuffer = new StringBuffer();
		String sqlAppend ="";
		String sql = "select * from student_info";
		boolean flag = false;  //标记是否已经进入
		if(searchId!=null&&!searchId.equals("")){
			flag = true;
			sqlBuffer.append(" student_id like '%"+searchId+"%' and");
		}
		if(searchName!=null&&!searchName.equals("")){
			flag = true;
			sqlBuffer.append(" student_name like '%"+searchName+"%' and");
		}
		if(date_from!=null&&!date_from.equals("")){
			flag = true;
			sqlBuffer.append(" update_time >= '"+date_from+"' and");
		}
		if(date_to!=null&&!date_to.equals("")){
			flag = true;
			sqlBuffer.append(" update_time <= '"+date_to+"' and");
		}
		if(flag){
			sqlBuffer.insert(0, " where"); //前面加上where
			sqlAppend = sqlBuffer.substring(0,sqlBuffer.length()-3); //移除最后一个and
		}
		String sqlLimit =  " limit "+first+","+rows; //查询多少列到多少列
		
		Gson gson = new GsonBuilder()  
				  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
				  .create();
		List<User> list = jdbcTemplate.query(sql+sqlAppend+sqlLimit, new UserRowMapper());
		List<Map<String,Object>> listMapAcademy = changeCode.changeAcademy(jdbcTemplate);
		List<Map<String,Object>> listMapMajor = changeCode.changeMajor(jdbcTemplate);
		for(int i =0;i<list.size();i++){
			//性别转码
			if(list.get(i).getS_sex().equals("1"))
				list.get(i).setS_sex("男");
			else
				list.get(i).setS_sex("女");
			
			//学院转码
			for(Map<String,Object> map:listMapAcademy){
				if(list.get(i).getS_academy().equals((String)map.get("academy_id"))){
					list.get(i).setS_academy((String)map.get("academy_name"));
				}			
			}
			//专业转码
			for(Map<String,Object> map:listMapMajor){
				if(list.get(i).getS_major().equals((String)map.get("major_id"))){
					list.get(i).setS_major((String)map.get("major_name"));
				}			
			}
		}
		String jsonArray = (String) gson.toJson(list);
		
		int total = getCounNumber(sqlAppend);
		String json = "{\"total\" :"+total+", \"rows\" : "+jsonArray+"}";
		
		return json;
	}
	
	
	@Override
	public int getCounNumber(String sqlAppend) {
		int i = jdbcTemplate.queryForObject("select count(*) from student_info "+sqlAppend, Integer.class);
		return i;
	}
	
	@Override
	@Transactional
	public boolean saveUser(String s_id,String s_name,String s_password,
			String s_sex,String s_academy,String s_major,String s_class,String s_grade){
		Date date = new Date();
		try {
			int i = jdbcTemplate.update("insert into student_info(student_id,student_name,student_password,student_sex,student_academy,student_major,student_class,student_grade,update_time) values(?,?,?,?,?,?,?,?,?)", 
					new Object[]{s_id,s_name,s_password,s_sex,s_academy,s_major, s_class, s_grade,date});
			if(i>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	
	@Override
	@Transactional
	public boolean updateUser(String s_id,String s_name,String s_password,
			String s_sex,String s_academy,String s_major,String s_class,String s_grade){
		Date date = new Date();
		List<Map<String,Object>> listMapAcademy = changeCode.changeAcademy(jdbcTemplate);
		List<Map<String,Object>> listMapMajor = changeCode.changeMajor(jdbcTemplate);
		//性别转码
		if(s_sex.equals("男")||s_sex.equals("1"))
			s_sex = "1";
		else if(s_sex.equals("女")||s_sex.equals("2"))
			s_sex = "2";
		
		//学院转码
		for(Map<String,Object> map:listMapAcademy){
			if(s_academy.equals((String)map.get("academy_name"))||s_academy.equals((String)map.get("academy_id"))){
				s_academy = (String)map.get("academy_id");
			}			
		}
		//专业转码
		for(Map<String,Object> map:listMapMajor){			
			if(s_major.equals((String)map.get("major_name"))||s_major.equals((String)map.get("major_id"))){
				s_major = (String)map.get("major_id");
			}
		}
		try {
			int i = jdbcTemplate.update("update student_info set student_name=?,student_password=?,student_sex=?,student_academy=?,student_major=?,student_class=?,student_grade=?,update_time=? where student_id=?", 
					new Object[]{s_name,s_password,s_sex,s_academy,s_major, s_class, s_grade,date,s_id});
			if(i>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	@Override
	@Transactional
	public boolean deleteUser(String s_id){
		try {
			int i = jdbcTemplate.update("delete from student_info where student_id =?",new Object[]{s_id});
			if(i>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}			
	}
	
	@Override
	@Transactional
	public boolean updatePassword(String s_id,String newpassword){
		try {
			int i = jdbcTemplate.update("update student_info set student_password=? where student_id=?",new Object[]{newpassword,s_id});
			if(i>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
