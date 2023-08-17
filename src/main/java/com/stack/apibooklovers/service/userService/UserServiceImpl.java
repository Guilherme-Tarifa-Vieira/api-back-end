package com.stack.apibooklovers.service.userService;

import com.stack.apibooklovers.domain.user.User;
import com.stack.apibooklovers.domain.user.UserForm;
import com.stack.apibooklovers.domain.user.UserResponseDTO;
import com.stack.apibooklovers.exception.ConflictEmail;
import com.stack.apibooklovers.exception.NoContentList;
import com.stack.apibooklovers.exception.UserByIdNotFound;
import com.stack.apibooklovers.mapper.Mapper;
import com.stack.apibooklovers.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) throw new NoContentList("Lista vazia!");
        return ResponseEntity.status(200).body(users.stream().map(Mapper::UserMapperDTO).toList());
    }


    @Override
    public UserResponseDTO getUserById(Long id) {
        Optional<User> opt = Optional.of(userRepository.findById(id).orElseThrow(() -> {
            throw new UserByIdNotFound(String.format("Usuário do %d não foi encontrado no sistema", id));
        }));
        User user = opt.get();
        return Mapper.UserMapperDTO(user);
    }

    @Override
    public ResponseEntity<UserResponseDTO> createUser(UserForm userForm) {
        Optional<User> op = userRepository.findUserByEmail(userForm.getEmail());
        if (op.isPresent()) throw new ConflictEmail("Email já cadastrado!");
        User newUser = new User(userForm.getFirstName(), userForm.getLastName(), userForm.getEmail(), userForm.getPassword(), userForm.getRole());

        userRepository.save(newUser);
        return ResponseEntity.status(201).body(Mapper.UserMapperDTO(newUser));
    }

    @Override
    public UserResponseDTO addBookToFavorites(Long userId, Long bookId) {
        Optional.of(userRepository.findById(userId).orElseThrow(() -> {
            throw new UserByIdNotFound(String.format("Usuário de id: %d não existente", userId));
        }));

        return null;
    }
}


