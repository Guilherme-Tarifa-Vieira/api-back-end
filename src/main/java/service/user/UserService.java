package service.user;

import domain.user.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAllUsers() throws Exception;
    UserResponseDTO getUserById(Long id) throws Exception;
    UserResponseDTO createUser(UserResponseDTO userDTO);

    UserResponseDTO addBookToFavorites(Long userId, Long bookId);
}
