package com.stack.apibooklovers.domain.publishing;

import com.stack.apibooklovers.domain.book.Book;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "tb_publishing_company")
public class PublishingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String adress;

    private Integer telephone;

    @OneToMany(mappedBy = "publishingCompany")
    private List<Book> books;


}
