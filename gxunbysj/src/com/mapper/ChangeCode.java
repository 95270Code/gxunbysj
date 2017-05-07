package com.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("changeCode")
public class ChangeCode {
	/**
	 * ѧԺ����ת��
	 * @param academy
	 * @return
	 */
	public List<Map<String,Object>> changeAcademy(JdbcTemplate jdbcTemplate){
		List<Map<String,Object>> list = jdbcTemplate.queryForList("select academy_id,academy_name from academy_info");		
		return list;	
	}
	
	/**
	 * רҵ����ת��
	 * @param major
	 * @return
	 */
	public List<Map<String,Object>> changeMajor(JdbcTemplate jdbcTemplate){
		List<Map<String,Object>> list = jdbcTemplate.queryForList("select major_id,major_name from major_info");		
		return list;	
	}
	
	public String changeSex(String sex){
		if(sex.equals("1"))
			return "��";
		else
			return "Ů";
	}
	
	public String changeXy(String xy,List<Map<String,Object>> listMapAcademy){
		
		for(Map<String,Object> map:listMapAcademy){
			if(xy.equals((String)map.get("academy_id"))){
				return (String)map.get("academy_name");
			}			
		}
		return xy;	
	}
	
	public String changeZy(String zy,List<Map<String,Object>> listMapMajor){
		
		for(Map<String,Object> map:listMapMajor){
			if(zy.equals((String)map.get("major_id"))){
				return (String)map.get("major_name");
			}			
		}
		return zy;	
	}
}
