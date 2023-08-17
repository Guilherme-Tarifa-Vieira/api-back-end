package com.stack.apibooklovers.service.bookService;

import com.stack.apibooklovers.domain.book.BookForm;
import com.stack.apibooklovers.domain.book.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BookService {

    public ResponseEntity<Page<BookResponseDTO>> getAllBooks(Pageable pageable);

    public ResponseEntity<BookResponseDTO> getBookById(Long id);

    public ResponseEntity<BookResponseDTO> createBook(BookForm form);

    public ResponseEntity<Page<BookResponseDTO>> filter(String title, Pageable pageable);


}
