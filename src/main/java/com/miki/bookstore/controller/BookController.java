package com.miki.bookstore.controller;

import com.miki.bookstore.model.Book;
import com.miki.bookstore.repository.BookRepository;
import com.miki.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> books =  bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
