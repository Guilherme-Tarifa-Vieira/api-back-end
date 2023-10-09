package com.stack.apibooklovers.service.bookService;

import com.stack.apibooklovers.domain.book.BookForm;
import com.stack.apibooklovers.domain.book.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BookService {

    Page<BookResponseDTO> getAllBooks(Pageable pageable);

    BookResponseDTO getBookById(Long id);

    BookResponseDTO createBook(BookForm form);

    Page<BookResponseDTO> filter(String title, Pageable pageable);


}
