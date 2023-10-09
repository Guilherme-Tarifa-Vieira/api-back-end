package com.stack.apibooklovers.service.authorService;

import com.stack.apibooklovers.domain.author.Author;
import com.stack.apibooklovers.domain.author.AuthorResponseDTO;
import com.stack.apibooklovers.infraestructure.exception.AuthorByIdNotFound;
import com.stack.apibooklovers.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

}

