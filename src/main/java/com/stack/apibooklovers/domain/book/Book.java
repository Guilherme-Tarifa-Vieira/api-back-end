package com.stack.apibooklovers.domain.book;


import com.stack.apibooklovers.domain.author.Author;
import com.stack.apibooklovers.domain.user.User;
import com.stack.apibooklovers.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Column(name = "isbn", unique = true)
    private String isbn;
    @ManyToMany
    @JoinTable(
            name = "tb_book_user_favorites",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookStatus status;


    public Book(String title, Author author, String isbn, BookStatus status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }


}


