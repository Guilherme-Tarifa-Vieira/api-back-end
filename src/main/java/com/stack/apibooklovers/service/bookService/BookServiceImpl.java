package com.stack.apibooklovers.service.bookService;

import com.stack.apibooklovers.domain.book.Book;
import com.stack.apibooklovers.domain.book.BookForm;
import com.stack.apibooklovers.domain.book.BookResponseDTO;
import com.stack.apibooklovers.exception.BookByIdNotFound;
import com.stack.apibooklovers.exception.ConflictIsbn;
import com.stack.apibooklovers.exception.NoContentList;
import com.stack.apibooklovers.mapper.Mapper;
import com.stack.apibooklovers.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty())
            throw new NoContentList("Lista vazia");
        return ResponseEntity.status(200).body(books.stream().map(Mapper::BookMapperDTO).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<BookResponseDTO> getBookById(Long id) {
        Optional<Book> opt = Optional.of(bookRepository.findById(id).orElseThrow(() -> {
            throw new BookByIdNotFound(String.format("\"Livros de id: %d - não encontrado\"", id));
        }));
        Book book = opt.get();
        return ResponseEntity.status(200).body(Mapper.BookMapperDTO(book));
    }

    @Override
    public ResponseEntity<BookResponseDTO> createBook(BookForm form) {
        Optional<Book> opt = bookRepository.findByIsbn(form.getIsbn());
        if (opt.isPresent())
            throw new ConflictIsbn("ISBN já cadastrado!");

        Book newBook = new Book(
                form.getTitle(),
                form.getAuthor(),
                form.getIsbn(),
                form.getStatus()
        );
        bookRepository.save(newBook);
        return ResponseEntity.status(201).body(Mapper.BookMapperDTO(newBook));
    }
}






