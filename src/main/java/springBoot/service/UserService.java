package springBoot.service;

import springBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User getUserByEmail(String email); // новый метод
}