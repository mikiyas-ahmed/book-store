package com.miki.bookstore.repository;

import com.miki.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long> , JpaSpecificationExecutor<Book> {
}
