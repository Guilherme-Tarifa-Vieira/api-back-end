package com.stack.apibooklovers.domain.book;

import com.stack.apibooklovers.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookForm {
    @NotBlank
    private String title;

    private Long author;
    @NotBlank
    private String isbn;
    private BookStatus status;
}
