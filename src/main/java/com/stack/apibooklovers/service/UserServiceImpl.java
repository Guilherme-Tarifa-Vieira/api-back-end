package com.stack.apibooklovers.service;

import com.stack.apibooklovers.domain.user.User;
import com.stack.apibooklovers.domain.user.UserResponseDTO;
import com.stack.apibooklovers.mapper.UserMapper;
import com.stack.apibooklovers.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) return ResponseEntity.status(204).body(new ArrayList<>());
        return ResponseEntity.status(200).body(users.stream().map(UserMapper::UserMapperDTO).collect(Collectors.toList()));
    }


    @Override
    public UserResponseDTO getUserById(Long id) throws Exception {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()) throw new Exception("Not Found user with id: " + id);
        User user = opt.get();
        return UserMapper.UserMapperDTO(user);
    }

    @Override
    public UserResponseDTO createUser(UserResponseDTO userDTO) {
        return null;
    }


    @Override
    public UserResponseDTO addBookToFavorites(Long userId, Long bookId) {
        return null;
    }


}