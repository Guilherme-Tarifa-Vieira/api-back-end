package com.stack.apibooklovers.service.bookService;

import com.stack.apibooklovers.domain.author.Author;
import com.stack.apibooklovers.domain.book.Book;
import com.stack.apibooklovers.domain.book.BookForm;
import com.stack.apibooklovers.domain.book.BookResponseDTO;
import com.stack.apibooklovers.exception.BookByIdNotFound;
import com.stack.apibooklovers.exception.ConflictIsbn;
import com.stack.apibooklovers.exception.NoContentList;
import com.stack.apibooklovers.mapper.Mapper;
import com.stack.apibooklovers.repository.BookRepository;
import com.stack.apibooklovers.service.authorService.AuthorService;
import com.stack.apibooklovers.specification.BookSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public ResponseEntity<Page<BookResponseDTO>> getAllBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        if (books.isEmpty()) throw new NoContentList("Lista vazia");
        List<BookResponseDTO> bookDto = books.getContent().stream().map(Mapper::BookMapperDTO).toList();
        Page<BookResponseDTO> response =
                new PageImpl<>(bookDto, pageable, books.getTotalElements());
        return ResponseEntity.status(200).body(response);

        
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
        Long authorId = form.getAuthor();

        ResponseEntity<Author> authorResponseEntity = authorService.findAuthorById(authorId);
        Author author = authorResponseEntity.getBody();


        Optional<Book> optBook = bookRepository.findByIsbn(form.getIsbn());
        if (optBook.isPresent()) throw new ConflictIsbn("ISBN já cadastrado!");


        Book newBook = new Book(form.getTitle(), author, form.getIsbn(), form.getStatus());

        bookRepository.save(newBook);

        return ResponseEntity.status(201).body(Mapper.BookMapperDTO(newBook));
    }


    @Override
    public ResponseEntity<Page<BookResponseDTO>> filter(String title, Pageable pageable) {
        Specification<Book> specification = Specification.where(title != null ? BookSpecification.titleLike(title) : null);
        Page<Book> books = bookRepository.findAll(specification, pageable);
        if (books.isEmpty()) throw new NoContentList("Sem nenhum resultado!");
        List<BookResponseDTO> booksDto = books.getContent().stream().map(Mapper::BookMapperDTO).toList();
        Page<BookResponseDTO> response = new PageImpl<>(booksDto, pageable, books.getTotalElements());
        return ResponseEntity.ok(response);
    }
}







