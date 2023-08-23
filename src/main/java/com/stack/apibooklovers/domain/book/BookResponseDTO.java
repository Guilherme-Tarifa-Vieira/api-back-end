package com.stack.apibooklovers.domain.book;

import com.stack.apibooklovers.enums.BookStatus;
import lombok.Data;


@Data
public class BookResponseDTO {
    private Long id;
    private String title;
    private Long author;
    private String isbn;
    private BookStatus status;

}

