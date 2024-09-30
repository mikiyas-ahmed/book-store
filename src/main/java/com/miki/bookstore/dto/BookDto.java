package com.miki.bookstore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {

    private Long id;
    private String title;
    private int publication_year;
    private double rating;
    private double price;
    private String genre;
}
