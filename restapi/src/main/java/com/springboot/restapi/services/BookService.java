package com.springboot.restapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.restapi.dao.BookRepositpry;
import com.springboot.restapi.entities.Books;

@Service
public class BookService {

    // private static List<Books> list = new ArrayList<Books>();

    // static {
    // list.add(new Books(1001, "Java Rest API", "XYZ"));
    // list.add(new Books(1002, "Java Spring Boot", "XYZ"));
    // list.add(new Books(1003, "Java Hibernate", "XYZ"));
    // }

    @Autowired
    private BookRepositpry bookRepositpry;

    public List<Books> getBooks() {
        return (List<Books>) bookRepositpry.findAll();
    }

    public Books getBookById(int id) {
        Books book = null;
        try {
            // book = list.stream().filter(it -> it.getId() == id).findFirst().get();
            book = bookRepositpry.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    public List<Books> addBooks(List<Books> books) {
        return (List<Books>) bookRepositpry.saveAll(books);
    }

    public Books addBook(@RequestBody Books book) {
        return bookRepositpry.save(book);
    }

    public void removeBook(int id) {
        bookRepositpry.deleteById(id);
    }

    public void updateBook(int id, Books book) {
        book.setId(id);
        bookRepositpry.save(book);
    }
}
