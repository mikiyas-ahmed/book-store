package com.miki.bookstore.service;

import com.miki.bookstore.model.Book;
import com.miki.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService

{
    private final BookRepository bookRepo;

    public  BookService(BookRepository bookRepo){
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }
}
