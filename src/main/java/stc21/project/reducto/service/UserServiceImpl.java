package stc21.project.reducto.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import stc21.project.reducto.dto.UserDTO;
import stc21.project.reducto.entity.User;
import stc21.project.reducto.repository.UserRepository;

import java.util.List;
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
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUsername(String username) {
        return convertToDTO(userRepository.findByUsername(username));
    }

    private UserDTO convertToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
