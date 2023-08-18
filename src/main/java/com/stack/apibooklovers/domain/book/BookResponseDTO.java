package com.stack.apibooklovers.domain.book;

import com.stack.apibooklovers.domain.author.Author;
import com.stack.apibooklovers.enums.BookStatus;
import lombok.Data;


@Data
public class BookResponseDTO {
    private Long id;
    private String title;
    private Author author;
    private String isbn;
    private BookStatus status;

}

