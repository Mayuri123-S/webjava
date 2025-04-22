package com.sunbeam.controllers;

import com.sunbeam.daos.BookDao;
import com.sunbeam.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;

@Controller
public class BookController {

    @Autowired
    private BookDao bookDao;

    @PostMapping("/showbooks")
    public String showBooks(@RequestParam String subject, HttpServletRequest request) {
        List<Book> bookList = bookDao.findBySubject(subject);
        request.setAttribute("bookList", bookList);
        return "books"; 
    }
}
