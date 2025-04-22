package com.sunbeam.daos;
import com.sunbeam.entities.Book;
import java.util.*;

public interface BookDao {
    List<Book> findBySubject(String subject);
    List<Book> findAll();
}
