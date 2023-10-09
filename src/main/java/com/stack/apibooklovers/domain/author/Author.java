package com.stack.apibooklovers.domain.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stack.apibooklovers.domain.book.Book;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birth_day;
    @OneToMany(mappedBy = "author")
    List<Book> books;

    public Author(String name, LocalDate birth_day) {
        this.name = name;
        this.birth_day = birth_day;
    }

}




