package com.example.collegebuddy.controller;

import com.example.collegebuddy.model.Book;
import com.example.collegebuddy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Add a new book for sale
    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return "Book listed for sale successfully!";
    }

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get books by seller email
    @GetMapping("/seller/{email}")
    public List<Book> getBooksBySeller(@PathVariable String email) {
        return bookRepository.findBySellerEmail(email);
    }
}
