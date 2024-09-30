package com.miki.bookstore.service;

import com.miki.bookstore.model.Book;
import com.miki.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookSpecification {
    private  final BookRepository bookRepository;

    public Specification<Book> hasTitle(String title){
        return (root,query, cb) -> cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }
    public Specification<Book> hasPublicationYear(Integer publicationYear){
        return (root,query, cb) -> cb.equal(root.get("publicationYear"), publicationYear);
    }

    public Specification<Book> hasAuthorName(String author_name){
        return (root,query, cb) -> cb.like(cb.lower(root.get("author_name")), "%" + author_name.toLowerCase() + "%");
    }

    public Specification<Book> hasRating(Double rating){
        return (root,query, cb) -> cb.equal(root.get("rating"), rating);
    }

    public List<Book> findTransactionList(String title, Integer publicationYear, String authorName, Double rating) {
        Specification<Book> spec = Specification.where(null);

        if (title != null) {
            spec = spec.and(hasTitle(title));
        }
        if (publicationYear != null) {
            spec = spec.and(hasPublicationYear(publicationYear));
        }
        if (authorName != null) {
            spec = spec.and(hasAuthorName(authorName));
        }
        if (rating != null) {
            spec = spec.and(hasRating(rating));
        }

        return bookRepository.findAll(spec);

//        return bookRepository.findAll(Specification.where(
//                        transactionListFromIdIn(idList)
//                                .and(transactionListFromDate(fromDate))
//                                .and(transactionListToDate(toDate))
//                )
//        );

    }
}
