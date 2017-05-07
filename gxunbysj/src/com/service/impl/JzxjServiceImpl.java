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
	 * 提交申请表
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
	 * 更新申请表，按照申请表编号
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
	 * 查询申请表（有条件
	 */
	@Override
	public String queryForm(String type,String xh,String xm,String date_from,String date_to,String page,String rows,String zy,String xy,String nj,String sfqrtj,String bjyj,String xyyj){
		StringBuffer sql = new StringBuffer();
		sql.append("select * from "+type);
		int number1 = Integer.parseInt(page);  //第几页
		int number2 = Integer.parseInt(rows);  //每页显示多少条记录
		int first = number2*(number1-1);  //从数据库的哪一条开始查
		StringBuffer sqlBuffer = new StringBuffer();
		String sqlAppend ="";
		boolean flag = false;  //标记是否已经进入
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
			sqlBuffer.insert(0, " where"); //前面加上where
			sqlAppend = sqlBuffer.substring(0,sqlBuffer.length()-3); //移除最后一个and
		}
		String descString = " ORDER BY scsj desc";
		String sqlLimit =  " limit "+first+","+rows; //查询多少列到多少列
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
				g.setSfqrtj("班级审核中");
				if(g.getBjyj()!=null&&g.getBjyj().equals("Y")){
					g.setSfqrtj("学院审核中");
					if(g.getXyyj()!=null&&g.getXyyj().equals("Y")){
						g.setSfqrtj("完成审核");
					}else if(g.getXyyj()!=null&&g.getXyyj().equals("N")){
						g.setSfqrtj("学院审核不通过");
					}
				}else if(g.getBjyj()!=null&&g.getBjyj().equals("N")){
					g.setSfqrtj("班级审核不通过");
				}
			} 								
			else{
				g.setSfqrtj("未提交");
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
	 * 获取申请表总数
	 */
	@Override
	public int getForRowNumber(String type,String sqlAppend){
		int i = jdbcTemplate.queryForObject("select count(*) from "+type+sqlAppend, Integer.class);
		return i;		
	}
	
	
	/**
	 * 查询申请表最后一条记录（按照生成时间
	 */
	@Override
	public String selectLastOne() {
		String sql = "select t.sqbbh from gjlzjxjsqb t ORDER BY scsj DESC LIMIT 1 ";
		try{
			String sqbbh = jdbcTemplate.queryForObject(sql, String.class);
			return sqbbh;
		}catch (Exception e) {
			System.out.println("数据库无此数据");
			return "GJLZJXJ-0";
		}
	}

	
	/**
	 * 获取申请表的某条记录
	 */
	@Override
	public Gjlzjxjsqb getGjlzjxjsqbBySqbbh(String sqbbh,String type) {
		
		String sql = "select * from  "+type+" where sqbbh=?";	
		try{
			Gjlzjxjsqb gjlzjxjsqb = jdbcTemplate.queryForObject(sql,new Object[]{sqbbh},new GjlzjxjsqbRowMapper());
			gjlzjxjsqb.setCsnyString(gjlzjxjsqb.getCsny()+"");
			return gjlzjxjsqb;
		}catch (Exception e) {
			System.out.println("数据库无此数据");
			return null;
		}

	}
	
	
	/**
	 * 班级推荐意见---插入
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
			System.out.println("数据库无此数据");
			return false;
		}
		
	}
	
	
	/**
	 * 学院审核意见---插入
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
			System.out.println("数据库无此数据");
			return false;
		}
		
	}
	
	/**
	 * 插入图片路径到数据库里面
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
			System.out.println("数据库无此数据");
			return false;
		}
	}
	
	
	/**
	 * 通过申请表编号获取图片路径
	 */
	@Override
	public String getSqbFilePath(String type,String sqbbh){
		
		String sql = "select t.zplj from "+type+" t where t.sqbbh=? ";
		try{
			String filePath = jdbcTemplate.queryForObject(sql,new Object[]{sqbbh}, String.class);
			return filePath;
		}catch (Exception e) {
			System.out.println("数据库无此数据");
			return null;
		}
	}

}
