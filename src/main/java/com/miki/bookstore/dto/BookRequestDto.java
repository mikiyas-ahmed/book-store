package com.miki.bookstore.dto;

import com.miki.bookstore.model.Book;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookRequestDto {

    @NotNull()
    @Size(min = 1, max = 255)
    private String title;

    @NotNull()
    @Min(value = 0)
    private int publication_year;

    @NotNull()
    @Min(value = 0)
    @Max(value = 5)
    private double rating;

    @NotNull()
    @Min(value = 0)
    private double price;

    @NotNull()
    @Size(min = 1, max = 100)
    private String genre;

    @NotNull()
    @Size(min = 1, max = 100)
    private String author_name;

    public Book mapToEntity(){
        return Book.builder()
                .genre(this.genre)
                .price(this.price)
                .publication_year(this.publication_year)
                .author_name(this.author_name)
                .rating(this.rating)
                .title(this.title)
                .build();
    }
}
