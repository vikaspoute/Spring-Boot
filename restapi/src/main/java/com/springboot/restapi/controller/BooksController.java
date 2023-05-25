package com.springboot.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.entities.Books;
import com.springboot.restapi.services.BookService;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Books>> getBooks() {

        List<Books> books = bookService.getBooks();
        if (books == null || books.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(books);
    }

    @GetMapping(value = "book/{id}")
    public ResponseEntity<Books> getBook(@PathVariable("id") int id) {
        Books book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<List<Books>> addBooks(@RequestBody List<Books> books) {

        List<Books> books2 = null;
        try {
            books2 = this.bookService.addBooks(books);
            return ResponseEntity.of(Optional.of(books2));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/book")
    public ResponseEntity<Books> addBook(@RequestBody Books book) {
        Books b = null;
        try {
            b = bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> removeBook(@PathVariable("id") int id) {

        try {
            this.bookService.removeBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable("id") int id, @RequestBody Books book) {
        try {
            this.bookService.updateBook(id, book);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
