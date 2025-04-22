package com.sunbeam.daos;

import com.sunbeam.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Customer mapRow(ResultSet rs) throws SQLException {
        Customer c = new Customer();
        c.setId(rs.getInt("id"));
        c.setName(rs.getString("name"));
        c.setPassword(rs.getString("password"));
        c.setMobile(rs.getString("mobile"));
        c.setAddress(rs.getString("address"));
        c.setEmail(rs.getString("email"));
        c.setBirth(rs.getDate("birth").toLocalDate());
        return c;
    }

    @Override
    public Customer findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM customers WHERE email=? AND password=?";
        return jdbcTemplate.query(sql, rs -> rs.next() ? mapRow(rs) : null, email, password);
    }
}
