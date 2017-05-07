package com.service;


import com.entity.Gjlzjxjsqb;

public interface JzxjService {
	public boolean submitForm(Gjlzjxjsqb gjlzjxjsqb,String sqbbh);
	public String selectLastOne();
	public boolean updateForm(Gjlzjxjsqb gjlzjxjsqb, String sqbbhString,String sfqrtj);
	public String queryForm(String type,String xh,String xm,String date_from,String date_to,String page,String rows,String zy,String xy,String nj,String sftjsq,String bjyj,String xyyj);
	public int getForRowNumber(String type,String sqlAppend);
	public Gjlzjxjsqb getGjlzjxjsqbBySqbbh(String sqbbh,String type);
	public boolean bjyjAdd(String sqbbh,String type,String bjyj,String bjtjyj);
	public boolean xyyjAdd(String sqbbh,String type,String xyyj,String xyshyj);
	public boolean insertImgPath(String type,String sqbbh,String fileName);
	public String getSqbFilePath(String type,String sqbbh);
}
