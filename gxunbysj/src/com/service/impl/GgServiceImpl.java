package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.entity.Gg;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapper.GgRowMapper;
import com.service.GgService;
@Service("ggService")
public class GgServiceImpl implements GgService{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * �������ҳ���ִ�еķ������������ִ�еķ���
	 */
	@Override
	public String getAllgg(String page,String rows,String searchId,String searchName,String date_from,String date_to) {
		int number1 = Integer.parseInt(page);  //�ڼ�ҳ
		int number2 = Integer.parseInt(rows);  //ÿҳ��ʾ��������¼
		int first = number2*(number1-1);  //�����ݿ����һ����ʼ��
		StringBuffer sqlBuffer = new StringBuffer();
		String sqlAppend ="";
		String sql = "select * from gg";
		boolean flag = false;  //����Ƿ��Ѿ�����
		if(searchId!=null&&!searchId.equals("")){
			flag = true;
			sqlBuffer.append(" ggbt like '%"+searchId+"%' and");
		}
		if(searchName!=null&&!searchName.equals("")){
			flag = true;
			sqlBuffer.append(" ggnr like '%"+searchName+"%' and");
		}
		if(date_from!=null&&!date_from.equals("")){
			flag = true;
			sqlBuffer.append(" ggfbsj >= '"+date_from+"' and");
		}
		if(date_to!=null&&!date_to.equals("")){
			flag = true;
			sqlBuffer.append(" ggfbsj <= '"+date_to+"' and");
		}
		if(flag){
			sqlBuffer.insert(0, " where"); //ǰ�����where
			sqlAppend = sqlBuffer.substring(0,sqlBuffer.length()-3); //�Ƴ����һ��and
		}
		String sqlLimit =  " limit "+first+","+rows; //��ѯ�����е�������
		
		Gson gson = new GsonBuilder()  
				  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
				  .create();
		List<Gg> list = jdbcTemplate.query(sql+sqlAppend+sqlLimit, new GgRowMapper());
		
		
		String jsonArray = (String) gson.toJson(list);
		
		int total = getCountgg(sqlAppend);
		String json = "{\"total\" :"+total+", \"rows\" : "+jsonArray+"}";
		
		return json;
	}
	
	@Override
	public int getCountgg(String sqlAppend) {
		int i = jdbcTemplate.queryForObject("select count(*) from gg "+sqlAppend, Integer.class);
		return i;
	}
}
