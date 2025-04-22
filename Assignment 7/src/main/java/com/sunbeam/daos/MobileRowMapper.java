package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.pojos.Mobile;

@Component
public class MobileRowMapper implements RowMapper<Mobile> {
	@Override
	public Mobile mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mobile m = new Mobile();
		m.setId(rs.getInt("id"));
		m.setName(rs.getString("mname"));
		m.setRam(rs.getInt("ram"));
		m.setStorage(rs.getInt("storage"));
		m.setCompany(rs.getString("company"));
		m.setPrice(rs.getDouble("price"));
		m.setImage(rs.getString("image"));
		return m;
	}
}
