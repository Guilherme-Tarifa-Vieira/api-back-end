package controller;

import domain.user.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.user.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUser() throws Exception {
        List<UserResponseDTO> users = userService.getAllUsers();
        if (users.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(users);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@Valid @PathVariable Long id) throws Exception {
        UserResponseDTO user = userService.getUserById(id);
        if (user == null) return ResponseEntity.status(404).build();
        return ResponseEntity.status(200).body(user);
    }
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserResponseDTO userDTO) {
        UserResponseDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(201).body(createdUser);
    }
    @PostMapping("/{userId}/books/{bookId}")
    public ResponseEntity<UserResponseDTO> addBookToFavorites(@PathVariable Long userId, @PathVariable Long bookId) {
        UserResponseDTO userWithAddedBook = userService.addBookToFavorites(userId, bookId);
        return ResponseEntity.ok(userWithAddedBook);
    }

}





