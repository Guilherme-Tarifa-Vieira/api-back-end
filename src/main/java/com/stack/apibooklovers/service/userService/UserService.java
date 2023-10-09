package com.stack.apibooklovers.service.userService;

import com.stack.apibooklovers.domain.user.UserForm;
import com.stack.apibooklovers.domain.user.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {

    Page<UserResponseDTO> getAllUsers(Pageable pageable);

    UserResponseDTO getUserById(Long id);


    UserResponseDTO createUser(UserForm user);

    UserResponseDTO addBookToFavorites(Long userId, Long bookId);
}