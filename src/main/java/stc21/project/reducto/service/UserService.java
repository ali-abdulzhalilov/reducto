package stc21.project.reducto.service;

import stc21.project.reducto.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO findByUsername(String username);
}