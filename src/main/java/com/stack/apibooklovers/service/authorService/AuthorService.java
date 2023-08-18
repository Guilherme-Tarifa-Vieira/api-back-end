package com.stack.apibooklovers.service.authorService;

import com.stack.apibooklovers.domain.author.Author;
import org.springframework.http.ResponseEntity;

public interface AuthorService {
    public ResponseEntity<Author> findAuthorById(Long id);
}
