package stc21.project.reducto.service;

import stc21.project.reducto.dto.UserDto;
import stc21.project.reducto.dto.UserRegistrationDto;
import stc21.project.reducto.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto findByUsername(String username);
    UserDto findByEmail(String email);
    UserDto findByPhoneNumber(String phoneNumber);

    User save(UserRegistrationDto userRegistrationDto);
}