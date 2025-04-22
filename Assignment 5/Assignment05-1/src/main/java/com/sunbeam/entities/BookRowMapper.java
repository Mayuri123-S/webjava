package com.sunbeam.entities;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("author"),
                rs.getString("subject"),
                rs.getDouble("price")
        );
    }
}
