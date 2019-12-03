package stc21.project.reducto.service;

import stc21.project.reducto.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findByUsername(String username);
}