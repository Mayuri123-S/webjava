package com.sunbeam.daos;

import com.sunbeam.entities.Book;
import com.sunbeam.entities.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BookRowMapper bookRowMapper;

    @Override
    public List<Book> findBySubject(String subject) {
        String sql = "SELECT * FROM books WHERE subject = ?";
        return jdbcTemplate.query(sql, bookRowMapper, subject);
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM books", bookRowMapper);
    }
}
