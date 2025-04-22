package com.sunbeam.daos;
import com.sunbeam.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.Mobile;
@Repository
public class MobileDaoImpl implements MobileDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MobileRowMapper mobileRowMapper;
	
	@Override
	public Mobile findById(int id) {
		String sql = "SELECT * FROM mobiles WHERE id = ?";
		List<Mobile> list = jdbcTemplate.query(sql, mobileRowMapper, id);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public List<Mobile> findAll() {
		String sql = "SELECT * FROM mobiles";
		List<Mobile> list = jdbcTemplate.query(sql, mobileRowMapper);
		return list;
	}
	
	@Override
	public int save(Mobile m) {
		String sql = "INSERT INTO mobiles (mname, ram, storage, company, price, image) VALUES (?, ?, ?, ?, ?, ?)";
		int count = jdbcTemplate.update(sql, m.getName(), m.getRam(), m.getStorage(), m.getCompany(), m.getPrice(), m.getImage());
		return count;
	}

	@Override
	public List<MobileDao> findADaos() {
		// TODO Auto-generated method stub
		return null;
	}
}
