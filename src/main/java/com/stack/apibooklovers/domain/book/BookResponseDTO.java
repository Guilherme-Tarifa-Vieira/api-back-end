package com.stack.apibooklovers.domain.book;

import com.stack.apibooklovers.domain.author.AuthorResponseDTO;
import com.stack.apibooklovers.enums.BookStatus;
import lombok.Data;


@Data
public class BookResponseDTO {
    private Long id;
    private String title;
    private AuthorResponseDTO author;
    private String isbn;
    private BookStatus status;

}

