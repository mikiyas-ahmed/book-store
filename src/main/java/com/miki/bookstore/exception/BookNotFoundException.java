package com.miki.bookstore.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(){
       super("Book not found");
    }
}
