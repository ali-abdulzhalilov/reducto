package stc21.project.reducto.service;

import org.springframework.validation.BindingResult;
import stc21.project.reducto.dto.UserDto;
import stc21.project.reducto.dto.UserRegistrationDto;
import stc21.project.reducto.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto findByUsername(String username);
    UserDto findByEmail(String email);
    UserDto findByPhoneNumber(String phoneNumber);

    List<String> fieldsWithErrors(UserRegistrationDto userRegistrationDto);
    User save(UserRegistrationDto userRegistrationDto);
}