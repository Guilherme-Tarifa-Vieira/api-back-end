package com.stack.apibooklovers.controller;

import com.stack.apibooklovers.domain.user.UserForm;
import com.stack.apibooklovers.domain.user.UserResponseDTO;
import com.stack.apibooklovers.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers().getBody());
    }


    @GetMapping("/{id}")

    public ResponseEntity<UserResponseDTO> getUserById(@Valid @PathVariable Long id) {
        UserResponseDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserForm userForm) {
        return ResponseEntity.status(201).body(userService.createUser(userForm).getBody());
    }


    @PostMapping("/{userId}/books/{bookId}")
    public ResponseEntity<UserResponseDTO> addBookToFavorites(@PathVariable Long userId, @PathVariable Long bookId) {
        UserResponseDTO userWithAddedBook = userService.addBookToFavorites(userId, bookId);
        return ResponseEntity.ok(userWithAddedBook);
    }

}





