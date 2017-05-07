package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.Gg;


public class GgRowMapper implements RowMapper<Gg>{

	@Override
	public Gg mapRow(ResultSet r, int i) throws SQLException {
		Gg g = new Gg();
		g.setBh(r.getInt("ggbh"));
		g.setNr(r.getString("ggnr"));
		g.setBt(r.getString("ggbt"));
		g.setFbsj(r.getTimestamp("ggfbsj"));
		g.setFbr(r.getString("ggfbr"));
		return g;
	}

}
