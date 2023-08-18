package com.stack.apibooklovers.domain.author;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorResponseDTO {
    private Long id;
    private String name;
    private LocalDate birth_day;
}
