package service.user;
import domain.user.User;
import domain.user.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() throws Exception{
        List<User> users = userRepository.findAll();
        if(users.isEmpty())
            throw new Exception("List User not content");

        return users.stream().map(user -> modelMapper.map(user, UserResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long id) throws Exception {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty())
            throw new Exception("Not Found user with id: " + id);
        User user = opt.get();
        return modelMapper.map(user, UserResponseDTO.class);
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










