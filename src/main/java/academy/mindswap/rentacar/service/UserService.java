package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.model.User;

import java.util.List;

public interface UserService {
   // User getUser();

    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
