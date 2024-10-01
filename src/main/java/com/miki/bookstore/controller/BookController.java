package com.miki.bookstore.controller;

import com.miki.bookstore.dto.BookRequestDto;
import com.miki.bookstore.model.Book;
import com.miki.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        Book books =  bookService.findById(id);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> saveBook(@RequestBody @Validated BookRequestDto bookRequest){
        Book books =  bookService.saveBook(bookRequest);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable("id") Long id, @RequestBody @Validated BookRequestDto bookRequest){
        Book book =  bookService.updateById(id,bookRequest);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
