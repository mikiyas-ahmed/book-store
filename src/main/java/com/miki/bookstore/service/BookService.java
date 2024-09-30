package com.miki.bookstore.service;

import com.miki.bookstore.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookSpecification bookSpecification;

    public List<Book> findBooks(String title, Integer publicationYear, String authorName, Double rating){

        return bookSpecification.findTransactionList(title, publicationYear, authorName, rating);
    }
}
