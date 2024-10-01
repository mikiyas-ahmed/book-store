package com.miki.bookstore.service;

import com.miki.bookstore.dto.BookRequestDto;
import com.miki.bookstore.exception.BookNotFoundException;
import com.miki.bookstore.model.Book;
import com.miki.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookSpecification bookSpecification;
    private final BookRepository bookRepository;

    public List<Book> findBooks(String title, Integer publicationYear, String authorName, Double rating)
    {

        return bookSpecification.findTransactionList(title, publicationYear, authorName, rating);
    }

    public Book findById(Long id)
    {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }
    public Book saveBook(BookRequestDto bookRequest){
        return bookRepository.save(bookRequest.mapToEntity());
    }

    public Book updateById(Long id , BookRequestDto bookRequest)
    {
        if(!bookRepository.existsById(id))
           throw new BookNotFoundException();
        Book book = bookRequest.mapToEntity();
        book.setId(id);
        return bookRepository.save(book);
    }
}
