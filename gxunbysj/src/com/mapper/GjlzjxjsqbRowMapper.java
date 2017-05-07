package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.Gjlzjxjsqb;

public class GjlzjxjsqbRowMapper implements RowMapper<Gjlzjxjsqb>{

	@Override
	public Gjlzjxjsqb mapRow(ResultSet rs, int i) throws SQLException {
		Gjlzjxjsqb g = new Gjlzjxjsqb();
		g.setBjshr(rs.getString("bjshr"));
		g.setBjyj(rs.getString("bjyj"));
		g.setBjtjyj(rs.getString("bjtjyj"));
		g.setBjzrs(rs.getInt("bjzrs"));
		g.setChhzjl(rs.getString("chhzjl"));
		g.setCjpm(rs.getInt("cjpm"));
		g.setCpzrs(rs.getInt("cpzrs"));
		g.setCsny(rs.getDate("csny"));
		g.setJsjdjqk(rs.getString("jsjdjqk"));
		g.setJthk(rs.getString("jthk"));
		g.setJtrkzs(rs.getInt("jtrkzs"));
		g.setJtysr(rs.getDouble("jtysr"));
		g.setJtzz(rs.getString("jtzz"));
		g.setKcs(rs.getInt("kcs"));
		g.setKhhmc(rs.getString("khhmc"));
		g.setLxdh(rs.getString("lxdh"));
		g.setMz(rs.getString("mz"));
		g.setNj(rs.getString("nj"));
		g.setPjf(rs.getDouble("pjf"));
		g.setQtkz(rs.getString("qtkz"));
		g.setRjysr(rs.getDouble("rjysr"));
		g.setSfqrtj(rs.getString("sfqrtj"));
		g.setSfzhm(rs.getString("sfzhm"));
		g.setSqbbh(rs.getString("sqbbh"));
		g.setSqly(rs.getString("sqly"));
		g.setSrly(rs.getString("srly"));
		g.setScsj(rs.getTimestamp("scsj"));
		g.setXb(rs.getString("xb"));
		g.setXh(rs.getString("xh"));
		g.setXm(rs.getString("xm"));
		g.setXxshr(rs.getString("xxshr"));
		g.setXxshyj(rs.getString("xxshyj"));
		g.setXy(rs.getString("xy"));
		g.setXyshr(rs.getString("xyshr"));
		g.setXyyj(rs.getString("xyyj"));
		g.setXyshyj(rs.getString("xyshyj"));
		g.setYhkh(rs.getString("yhkh"));
		g.setYygjqk(rs.getString("yygjqk"));
		g.setYzbm(rs.getString("yzbm"));
		g.setZdcj(rs.getDouble("zdcj"));
		g.setZhcppm(rs.getInt("zhcppm"));
		g.setZy(rs.getString("zy"));
		g.setZzmm(rs.getString("zzmm"));
		g.setZplj(rs.getString("zplj"));
		return g;
	}
	
}
