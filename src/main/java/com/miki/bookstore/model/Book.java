package com.miki.bookstore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publication_year", nullable = false)
    private int publication_year;

    @Column(name = "rating", nullable = false)
    private double rating;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(nullable = false, length = 100)
    private String author_name;
}
