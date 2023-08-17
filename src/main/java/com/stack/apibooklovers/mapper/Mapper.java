package com.stack.apibooklovers.mapper;

import com.stack.apibooklovers.domain.book.Book;
import com.stack.apibooklovers.domain.book.BookResponseDTO;
import com.stack.apibooklovers.domain.user.User;
import com.stack.apibooklovers.domain.user.UserResponseDTO;


public class Mapper {

    public static UserResponseDTO UserMapperDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public static BookResponseDTO BookMapperDTO(Book book) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setAuthor(book.getAuthor());
        dto.setStatus(book.getStatus());
        return dto;
    }


}