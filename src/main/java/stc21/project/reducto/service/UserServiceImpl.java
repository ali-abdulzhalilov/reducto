package stc21.project.reducto.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import stc21.project.reducto.dto.UserDto;
import stc21.project.reducto.dto.UserRegistrationDto;
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

    /* functions to work with repository */
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findByUsername(String username) {
        return convertToDTO(userRepository.findByUsername(username));
    }

    @Override
    public UserDto findByEmail(String email) {
        if (email == null || email.equals(""))
            return null;

        return convertToDTO(userRepository.findByEmail(email));
    }

    @Override
    public UserDto findByPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.equals(""))
            return null;

        return convertToDTO(userRepository.findByPhoneNumber(phoneNumber));
    }

    private UserDto convertToDTO(User user) {
        if (user == null) return null;

        return modelMapper.map(user, UserDto.class);
    }

     @Override
     public User save(UserRegistrationDto userRegistrationDto) {
        if (userRegistrationDto == null)
            throw new NullPointerException("No userRegistrationDto to save");

        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(userRegistrationDto.getPassword()); // TODO: to hash
        user.setEmail(userRegistrationDto.getEmail().equals("") ? null : userRegistrationDto.getEmail());
        user.setPhoneNumber(userRegistrationDto.getPhoneNumber().equals("") ? null : userRegistrationDto.getPhoneNumber());

        return userRepository.save(user);
    }
}
