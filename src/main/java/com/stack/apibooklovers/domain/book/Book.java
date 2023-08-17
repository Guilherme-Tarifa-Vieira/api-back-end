package com.stack.apibooklovers.domain.book;


import com.stack.apibooklovers.domain.author.Author;
import com.stack.apibooklovers.domain.user.User;
import com.stack.apibooklovers.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;


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
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Column(unique = true)
    private String isbn;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;
    @Enumerated(EnumType.STRING)
    private BookStatus status;


    public Book(String title, Author author, String isbn, BookStatus status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }


}


