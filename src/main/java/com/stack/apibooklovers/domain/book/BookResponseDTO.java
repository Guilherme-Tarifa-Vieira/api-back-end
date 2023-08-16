package com.stack.apibooklovers.domain.book;

import com.stack.apibooklovers.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class BookResponseDTO {
    @NotBlank
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    private Long userId;
    private BookStatus status;
}

