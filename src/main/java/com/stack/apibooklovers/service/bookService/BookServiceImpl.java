package com.stack.apibooklovers.service.bookService;

import com.stack.apibooklovers.domain.book.Book;
import com.stack.apibooklovers.domain.book.BookForm;
import com.stack.apibooklovers.domain.book.BookResponseDTO;
import com.stack.apibooklovers.infraestructure.exception.BookByIdNotFound;
import com.stack.apibooklovers.infraestructure.exception.ConflictIsbn;
import com.stack.apibooklovers.infraestructure.exception.NoContentList;
import com.stack.apibooklovers.repository.BookRepository;
import com.stack.apibooklovers.specification.BookSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<BookResponseDTO> getAllBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        if (books.isEmpty()) throw new NoContentList("Lista vazia");
        List<BookResponseDTO> bookDto = books.getContent().stream().map(book -> modelMapper.map(book, BookResponseDTO.class)).toList();
        return new PageImpl<>(bookDto, pageable, books.getTotalElements());
    }


    @Override
    public BookResponseDTO getBookById(Long id) {
        Optional<Book> opt = bookRepository.findById(id);
        Book book = opt.orElseThrow(() -> new BookByIdNotFound(String.format("Book with id: %d not found", id)));
        return modelMapper.map(book, BookResponseDTO.class);
    }

    @Override
    public BookResponseDTO createBook(BookForm form) {
        Optional<Book> optBook = bookRepository.findByIsbn(form.getIsbn());
        if (optBook.isPresent()) throw new ConflictIsbn("ISBN já cadastrado!");
        Book newBook = new Book();
        modelMapper.map(form, newBook);
        bookRepository.save(newBook);
        return modelMapper.map(newBook, BookResponseDTO.class);
    }


    @Override
    public Page<BookResponseDTO> filter(String title, Pageable pageable) {
        Specification<Book> specification = Specification.where(title != null ? BookSpecification.titleLike(title) : null);
        Page<Book> books = bookRepository.findAll(specification, pageable);
        if (books.isEmpty()) throw new NoContentList("Sem nenhum resultado!");
        List<BookResponseDTO> booksDto = books.getContent().stream().map(book -> modelMapper.map(book, BookResponseDTO.class)).toList();
        return new PageImpl<>(booksDto, pageable, books.getTotalElements());
    }
}







