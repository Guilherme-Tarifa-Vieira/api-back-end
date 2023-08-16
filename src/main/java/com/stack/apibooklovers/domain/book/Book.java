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
@Entity(name = "en_book")
@Table(name = "tb_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;
    @Enumerated(EnumType.STRING)
    private BookStatus status;


}


