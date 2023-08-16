package com.stack.apibooklovers.service;

import com.stack.apibooklovers.domain.user.UserForm;
import com.stack.apibooklovers.domain.user.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<List<UserResponseDTO>> getAllUsers();

    UserResponseDTO getUserById(Long id);


    ResponseEntity<UserResponseDTO> createUser(UserForm user);

    UserResponseDTO addBookToFavorites(Long userId, Long bookId);
}