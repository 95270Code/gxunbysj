package com.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Gjlzjxjsqb;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapper.ChangeCode;
import com.mapper.GjlzjxjsqbRowMapper;
import com.service.JzxjService;

@Service("jzxjService")
public class JzxjServiceImpl implements JzxjService{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * �ύ�����
	 */
	@Override
	@Transactional
	public boolean submitForm(Gjlzjxjsqb gjlzjxjsqb,String sqbbh) {
		
		try {
			
			int i = jdbcTemplate.update("INSERT INTO gjlzjxjsqb (sqbbh,xm,xb,csny,mz,zzmm,xh,sfzhm,lxdh,yhkh,khhmc,xy,nj,zy,chhzjl,jthk,jtrkzs,jtysr,rjysr,srly,jtzz,yzbm,kcs,pjf,zdcj,bjzrs,cjpm,zhcppm,cpzrs,yygjqk,jsjdjqk,qtkz,sqly,bjyj,bjshr,xyshyj,xyshr,xxshyj,xxshr,sfqrtj,scsj) VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					new Object[]{
					sqbbh,
					gjlzjxjsqb.getXm(),
					gjlzjxjsqb.getXb(),
					gjlzjxjsqb.getCsny(),
					gjlzjxjsqb.getMz(),
					gjlzjxjsqb.getZzmm(),
					gjlzjxjsqb.getXh(),
					gjlzjxjsqb.getSfzhm(),
					gjlzjxjsqb.getLxdh(),
					gjlzjxjsqb.getYhkh(),
					gjlzjxjsqb.getKhhmc(),
					gjlzjxjsqb.getXy(),
					gjlzjxjsqb.getNj(),
					gjlzjxjsqb.getZy(),
					gjlzjxjsqb.getChhzjl(),
					gjlzjxjsqb.getJthk(),
					gjlzjxjsqb.getJtrkzs(),
					gjlzjxjsqb.getJtysr(),
					gjlzjxjsqb.getRjysr(),
					gjlzjxjsqb.getSrly(),
					gjlzjxjsqb.getJtzz(),
					gjlzjxjsqb.getYzbm(),
					gjlzjxjsqb.getKcs(),
					gjlzjxjsqb.getPjf(),
					gjlzjxjsqb.getZdcj(),
					gjlzjxjsqb.getBjzrs(),
					gjlzjxjsqb.getCjpm(),
					gjlzjxjsqb.getZhcppm(),
					gjlzjxjsqb.getCpzrs(),
					gjlzjxjsqb.getYygjqk(),
					gjlzjxjsqb.getJsjdjqk(),
					gjlzjxjsqb.getQtkz(),
					gjlzjxjsqb.getSqly(),
					gjlzjxjsqb.getBjyj(),
					gjlzjxjsqb.getBjshr(),
					gjlzjxjsqb.getXyyj(),
					gjlzjxjsqb.getXyshr(),
					gjlzjxjsqb.getXxshyj(),
					gjlzjxjsqb.getXxshr(),
					gjlzjxjsqb.getSfqrtj(),
					new Date()
					});
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
	
	/**
	 * ��������������������
	 */
	@Override
	@Transactional
	public boolean updateForm(Gjlzjxjsqb gjlzjxjsqb,String sqbbh,String sfqrtj){
		try {
			int i = jdbcTemplate.update("UPDATE gjlzjxjsqb SET xm = ?,xb = ?,csny = ?,mz = ?,zzmm = ?,xh = ?,sfzhm = ?,lxdh = ?,yhkh = ?,khhmc = ?,xy = ?,nj = ?,zy = ?,chhzjl = ?,jthk = ?,jtrkzs = ?,jtysr = ?,rjysr = ?,srly = ?,jtzz = ?,yzbm = ?,kcs = ?,pjf = ?,zdcj = ?,bjzrs = ?,cjpm = ?,zhcppm =?,cpzrs=?,yygjqk = ?,jsjdjqk = ?,qtkz = ?,sqly = ?,bjyj = ?,bjshr = ?,xyyj = ?,xyshr = ?,xxshyj =?,xxshr = ?,sfqrtj = ?  where sqbbh = ?",new Object[]{
				gjlzjxjsqb.getXm(),
				gjlzjxjsqb.getXb(),
				gjlzjxjsqb.getCsny(),
				gjlzjxjsqb.getMz(),
				gjlzjxjsqb.getZzmm(),
				gjlzjxjsqb.getXh(),
				gjlzjxjsqb.getSfzhm(),
				gjlzjxjsqb.getLxdh(),
				gjlzjxjsqb.getYhkh(),
				gjlzjxjsqb.getKhhmc(),
				gjlzjxjsqb.getXy(),
				gjlzjxjsqb.getNj(),
				gjlzjxjsqb.getZy(),
				gjlzjxjsqb.getChhzjl(),
				gjlzjxjsqb.getJthk(),
				gjlzjxjsqb.getJtrkzs(),
				gjlzjxjsqb.getJtysr(),
				gjlzjxjsqb.getRjysr(),
				gjlzjxjsqb.getSrly(),
				gjlzjxjsqb.getJtzz(),
				gjlzjxjsqb.getYzbm(),
				gjlzjxjsqb.getKcs(),
				gjlzjxjsqb.getPjf(),
				gjlzjxjsqb.getZdcj(),
				gjlzjxjsqb.getBjzrs(),
				gjlzjxjsqb.getCjpm(),
				gjlzjxjsqb.getZhcppm(),
				gjlzjxjsqb.getCpzrs(),
				gjlzjxjsqb.getYygjqk(),
				gjlzjxjsqb.getJsjdjqk(),
				gjlzjxjsqb.getQtkz(),
				gjlzjxjsqb.getSqly(),
				gjlzjxjsqb.getBjyj(),
				gjlzjxjsqb.getBjshr(),
				gjlzjxjsqb.getXyyj(),
				gjlzjxjsqb.getXyshr(),
				gjlzjxjsqb.getXxshyj(),
				gjlzjxjsqb.getXxshr(),
				sfqrtj,
				sqbbh
				});
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
	
	/**
	 * ��ѯ�����������
	 */
	@Override
	public String queryForm(String type,String xh,String xm,String date_from,String date_to,String page,String rows,String zy,String xy,String nj,String sfqrtj,String bjyj,String xyyj){
		StringBuffer sql = new StringBuffer();
		sql.append("select * from "+type);
		int number1 = Integer.parseInt(page);  //�ڼ�ҳ
		int number2 = Integer.parseInt(rows);  //ÿҳ��ʾ��������¼
		int first = number2*(number1-1);  //�����ݿ����һ����ʼ��
		StringBuffer sqlBuffer = new StringBuffer();
		String sqlAppend ="";
		boolean flag = false;  //����Ƿ��Ѿ�����
		if(xh!=null&&!xh.equals("")){
			flag = true;
			sqlBuffer.append(" xh like '%"+xh+"%' and");
		}
		if(xm!=null&&!xm.equals("")){
			flag = true;
			sqlBuffer.append(" xm like '%"+xm+"%' and");
		}
		if(date_from!=null&&!date_from.equals("")){
			flag = true;
			sqlBuffer.append(" scsj >= '"+date_from+"' and");
		}
		if(date_to!=null&&!date_to.equals("")){
			flag = true;
			sqlBuffer.append(" scsj <= '"+date_to+"' and");
		}
		if(zy!=null&&!zy.equals("")){
			flag = true;
			sqlBuffer.append(" zy like '%"+zy+"%' and");
		}
		if(xy!=null&&!xy.equals("")){
			flag = true;
			sqlBuffer.append(" xy like '%"+xy+"%' and");
		}
		if(nj!=null&&!nj.equals("")){
			flag = true;
			sqlBuffer.append(" nj like '%"+nj+"%' and");
		}
		if(sfqrtj!=null&&!sfqrtj.equals("")){
			flag = true;
			sqlBuffer.append(" sfqrtj like '%"+sfqrtj+"%' and");
		}
		if(bjyj!=null&&!bjyj.equals("")){
			flag = true;
			sqlBuffer.append(" bjyj like '%"+bjyj+"%' and");
		}
		if(flag){
			sqlBuffer.insert(0, " where"); //ǰ�����where
			sqlAppend = sqlBuffer.substring(0,sqlBuffer.length()-3); //�Ƴ����һ��and
		}
		String descString = " ORDER BY scsj desc";
		String sqlLimit =  " limit "+first+","+rows; //��ѯ�����е�������
		List<Gjlzjxjsqb> list = jdbcTemplate.query(sql.toString()+sqlAppend+descString+sqlLimit, new GjlzjxjsqbRowMapper());
		ChangeCode changeCode = new ChangeCode();
		List<Map<String,Object>> listMapAcademy = changeCode.changeAcademy(jdbcTemplate);
		List<Map<String,Object>> listMapMajor = changeCode.changeMajor(jdbcTemplate);
		for (Gjlzjxjsqb g : list) {
			String xb = changeCode.changeSex(g.getXb());
			g.setXb(xb);
			String xyString = changeCode.changeXy(g.getXy(), listMapAcademy);
			g.setXy(xyString);
			String zyString = changeCode.changeZy(g.getZy(), listMapMajor);
			g.setZy(zyString);
			if(g.getSfqrtj()!=null&&g.getSfqrtj().equals("Y")){
				g.setSfqrtj("�༶�����");
				if(g.getBjyj()!=null&&g.getBjyj().equals("Y")){
					g.setSfqrtj("ѧԺ�����");
					if(g.getXyyj()!=null&&g.getXyyj().equals("Y")){
						g.setSfqrtj("������");
					}else if(g.getXyyj()!=null&&g.getXyyj().equals("N")){
						g.setSfqrtj("ѧԺ��˲�ͨ��");
					}
				}else if(g.getBjyj()!=null&&g.getBjyj().equals("N")){
					g.setSfqrtj("�༶��˲�ͨ��");
				}
			} 								
			else{
				g.setSfqrtj("δ�ύ");
			}
				
		}
		int total = getForRowNumber(type,sqlAppend);
		Gson gson = new GsonBuilder()  
				  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
				  .create();
		String listString = (String) gson.toJson(list);
		String json = "{\"total\" :"+total+", \"rows\" : "+listString+"}";	
		return json;
	}
	
	
	
	/**
	 * ��ȡ���������
	 */
	@Override
	public int getForRowNumber(String type,String sqlAppend){
		int i = jdbcTemplate.queryForObject("select count(*) from "+type+sqlAppend, Integer.class);
		return i;		
	}
	
	
	/**
	 * ��ѯ��������һ����¼����������ʱ��
	 */
	@Override
	public String selectLastOne() {
		String sql = "select t.sqbbh from gjlzjxjsqb t ORDER BY scsj DESC LIMIT 1 ";
		try{
			String sqbbh = jdbcTemplate.queryForObject(sql, String.class);
			return sqbbh;
		}catch (Exception e) {
			System.out.println("���ݿ��޴�����");
			return "GJLZJXJ-0";
		}
	}

	
	/**
	 * ��ȡ������ĳ����¼
	 */
	@Override
	public Gjlzjxjsqb getGjlzjxjsqbBySqbbh(String sqbbh,String type) {
		
		String sql = "select * from  "+type+" where sqbbh=?";	
		try{
			Gjlzjxjsqb gjlzjxjsqb = jdbcTemplate.queryForObject(sql,new Object[]{sqbbh},new GjlzjxjsqbRowMapper());
			gjlzjxjsqb.setCsnyString(gjlzjxjsqb.getCsny()+"");
			return gjlzjxjsqb;
		}catch (Exception e) {
			System.out.println("���ݿ��޴�����");
			return null;
		}

	}
	
	
	/**
	 * �༶�Ƽ����---����
	 * @param sqbbh
	 * @param type
	 * @param bjyj
	 * @param bjtjyj
	 * @return
	 */
	@Override
	public boolean bjyjAdd(String sqbbh,String type,String bjyj,String bjtjyj){
		String sql = "update "+type+" set bjyj=?,bjtjyj=? where sqbbh=?";	
		try{
			int i = jdbcTemplate.update(sql, new Object[]{bjyj,bjtjyj,sqbbh});
			if(i>0)
				return true;
			else
				return false;
		}catch (Exception e) {
			System.out.println("���ݿ��޴�����");
			return false;
		}
		
	}
	
	
	/**
	 * ѧԺ������---����
	 * @param sqbbh
	 * @param type
	 * @param bjyj
	 * @param bjtjyj
	 * @return
	 */
	@Override
	public boolean xyyjAdd(String sqbbh,String type,String xyyj,String xyshyj){
		String sql = "update "+type+" set xyyj=?,xyshyj=? where sqbbh=?";	
		try{
			int i = jdbcTemplate.update(sql, new Object[]{xyyj,xyshyj,sqbbh});
			if(i>0)
				return true;
			else
				return false;
		}catch (Exception e) {
			System.out.println("���ݿ��޴�����");
			return false;
		}
		
	}
	
	/**
	 * ����ͼƬ·�������ݿ�����
	 */
	@Override
	public boolean insertImgPath(String type,String sqbbh,String filePath){
		String sql = "update "+type+" set zplj=? where sqbbh=?";	
		try{
			int i = jdbcTemplate.update(sql, new Object[]{filePath,sqbbh});
			if(i>0)
				return true;
			else
				return false;
		}catch (Exception e) {
			System.out.println("���ݿ��޴�����");
			return false;
		}
	}
	
	
	/**
	 * ͨ��������Ż�ȡͼƬ·��
	 */
	@Override
	public String getSqbFilePath(String type,String sqbbh){
		
		String sql = "select t.zplj from "+type+" t where t.sqbbh=? ";
		try{
			String filePath = jdbcTemplate.queryForObject(sql,new Object[]{sqbbh}, String.class);
			return filePath;
		}catch (Exception e) {
			System.out.println("���ݿ��޴�����");
			return null;
		}
	}

}
