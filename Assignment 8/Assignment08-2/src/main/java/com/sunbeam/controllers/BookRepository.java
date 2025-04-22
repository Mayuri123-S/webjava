package com.sunbeam.controllers;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBySubject(String subject);
}
