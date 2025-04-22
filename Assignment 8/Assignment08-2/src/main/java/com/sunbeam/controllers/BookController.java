package com.sunbeam.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return bookRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/subject/{subject}")
    public List<Book> getBooksBySubject(@PathVariable String subject) {
        return bookRepository.findBySubject(subject);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id)
            .map(book -> {
                book.setName(updatedBook.getName());
                book.setAuthor(updatedBook.getAuthor());
                book.setSubject(updatedBook.getSubject());
                book.setPrice(updatedBook.getPrice());
                return ResponseEntity.ok(bookRepository.save(book));
            })
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        return bookRepository.findById(id)
            .map(book -> {
                bookRepository.delete(book);
                return ResponseEntity.ok().<Void>build();
            })
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
