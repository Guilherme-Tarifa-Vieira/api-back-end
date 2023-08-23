package com.stack.apibooklovers.mapper;

import com.stack.apibooklovers.domain.author.Author;
import com.stack.apibooklovers.domain.author.AuthorResponseDTO;
import com.stack.apibooklovers.domain.book.Book;
import com.stack.apibooklovers.domain.book.BookResponseDTO;
import com.stack.apibooklovers.domain.publishing.PublishingCompany;
import com.stack.apibooklovers.domain.publishing.PublishingCompanyResponseDTO;
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
        dto.setBooks(user.getBooks());
        return dto;
    }

    public static BookResponseDTO BookMapperDTO(Book book) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor().getId());
        dto.setIsbn(book.getIsbn());
        dto.setStatus(book.getStatus());
        return dto;
    }

    public static AuthorResponseDTO AuthorMapperDTO(Author author) {
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setBirth_day(author.getBirth_day());
        return dto;
    }

    public static PublishingCompanyResponseDTO PublishingMapperDTO(PublishingCompany publi) {
        PublishingCompanyResponseDTO dto = new PublishingCompanyResponseDTO();
        dto.setId(publi.getId());
        dto.setName(publi.getName());
        dto.setAdress(publi.getAdress());
        return dto;
    }




}