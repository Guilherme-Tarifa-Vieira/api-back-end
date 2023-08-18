package com.stack.apibooklovers.domain.user;

import com.stack.apibooklovers.domain.book.Book;
import com.stack.apibooklovers.enums.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private List<Book> books;


}

