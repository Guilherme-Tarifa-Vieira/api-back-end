package com.stack.apibooklovers.service.userService;

import com.stack.apibooklovers.domain.user.User;
import com.stack.apibooklovers.domain.user.UserForm;
import com.stack.apibooklovers.domain.user.UserResponseDTO;
import com.stack.apibooklovers.infraestructure.exception.ConflictEmail;
import com.stack.apibooklovers.infraestructure.exception.NoContentList;
import com.stack.apibooklovers.infraestructure.exception.UserByIdNotFound;
import com.stack.apibooklovers.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<UserResponseDTO> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        if (users.isEmpty()) throw new NoContentList("Lista vazia!");
        List<UserResponseDTO> usersDTOs = users.getContent().stream().map(user -> modelMapper.map(user, UserResponseDTO.class)).toList();
        return new PageImpl<>(usersDTOs, pageable, users.getTotalElements());
    }


    @Override
    public UserResponseDTO getUserById(Long id) {
        Optional<User> opt = userRepository.findById(id);
        User user = opt.orElseThrow(() -> new UserByIdNotFound(String.format("Usuário do %d não foi encontrado no sistema", id)));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO createUser(UserForm userForm) {
        Optional<User> op = userRepository.findUserByEmail(userForm.getEmail());
        if (op.isPresent()) throw new ConflictEmail("Email já cadastrado!");
        User newUser = new User();
        modelMapper.map(userForm, newUser);
        userRepository.save(newUser);
        return modelMapper.map(newUser, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO addBookToFavorites(Long userId, Long bookId) {
        Optional.of(userRepository.findById(userId).orElseThrow(() -> {
            throw new UserByIdNotFound(String.format("Usuário de id: %d não existente", userId));
        }));

        return null;
    }
}


