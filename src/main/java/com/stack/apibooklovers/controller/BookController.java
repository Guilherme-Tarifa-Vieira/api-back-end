package com.stack.apibooklovers.controller;

import com.stack.apibooklovers.domain.book.BookForm;
import com.stack.apibooklovers.domain.book.BookResponseDTO;
import com.stack.apibooklovers.service.bookService.BookService;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Page<BookResponseDTO>> getAllBooks(
            @ParameterObject
            @PageableDefault(size = 20, sort = "title", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(bookService.getAllBooks(pageable).getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> bookById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id).getBody());
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody BookForm form) {
        return ResponseEntity.status(201).body(bookService.createBook(form).getBody());
    }


    @GetMapping("/filter")
    public ResponseEntity<Page<BookResponseDTO>> filter(
            @RequestParam(required = false) String title,
            @ParameterObject
            @PageableDefault(size = 20, sort = "title", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(bookService.filter(title, pageable).getBody());
    }


}
