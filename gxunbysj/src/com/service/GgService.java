package com.service;

public interface GgService {
	public String getAllgg(String page,String rows,String searchId,String searchName,String date_from,String date_to);
	public int getCountgg(String sqlAppend);
}
