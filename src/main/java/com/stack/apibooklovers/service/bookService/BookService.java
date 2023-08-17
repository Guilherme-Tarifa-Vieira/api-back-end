package com.stack.apibooklovers.service.bookService;

import com.stack.apibooklovers.domain.book.BookForm;
import com.stack.apibooklovers.domain.book.BookResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {

    public ResponseEntity<List<BookResponseDTO>> getAllBooks();

    public ResponseEntity<BookResponseDTO> getBookById(Long id);

    public ResponseEntity<BookResponseDTO> createBook(BookForm form);


}
