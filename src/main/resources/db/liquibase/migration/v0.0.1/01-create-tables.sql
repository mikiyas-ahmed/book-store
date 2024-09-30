--liquibase formatted sql
--changeset mikiyas-ahmed:create-table-books
CREATE TABLE books (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       publication_year INT NOT NULL,
                       rating DECIMAL(2,1),
                       price DECIMAL(10,2),
                       genre VARCHAR(50),
                       author_name VARCHAR(100) NOT NULL
);
CREATE INDEX idx_books_title ON books(title);
CREATE INDEX idx_books_publication_year ON books(publication_year);
CREATE INDEX idx_books_rating ON books(rating);
CREATE INDEX idx_books_genre ON books(genre);
CREATE INDEX idx_books_price ON books(price);