package com.stack.apibooklovers.controller;

import com.stack.apibooklovers.domain.book.BookForm;
import com.stack.apibooklovers.domain.book.BookResponseDTO;
import com.stack.apibooklovers.service.bookService.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> bookById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id).getBody());
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody BookForm form) {
        return ResponseEntity.status(201).body(bookService.createBook(form).getBody());
    }


}
