package com.miki.bookstore.controller;

import com.miki.bookstore.model.Book;
import com.miki.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks( @RequestParam(required = false) String title,
                                                @RequestParam(required = false) Integer publicationYear,
                                                @RequestParam(required = false) String authorName,
                                                @RequestParam(required = false) Double rating){
        List<Book> books =  bookService.findBooks(title,publicationYear,authorName,rating);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
