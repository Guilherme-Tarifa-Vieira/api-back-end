package com.stack.apibooklovers.service.authorService;

import com.stack.apibooklovers.domain.author.Author;
import com.stack.apibooklovers.exception.AuthorByIdNotFound;
import com.stack.apibooklovers.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public ResponseEntity<Author> findAuthorById(Long id) {
        Optional<Author> opt = Optional.of(authorRepository.findById(id).orElseThrow(() -> {
            throw new AuthorByIdNotFound(String.format("Author with id: %d not found", id));
        }));
        return ResponseEntity.ok(opt.get());
    }
}

