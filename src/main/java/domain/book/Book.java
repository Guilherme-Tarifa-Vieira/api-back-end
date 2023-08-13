package domain.book;


import domain.author.Author;
import domain.user.User;
import enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
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
