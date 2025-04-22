package com.sunbeam.entities;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("mobile"),
                rs.getString("address"),
                rs.getString("email"),
                rs.getString("birth")
        );
    }
}
