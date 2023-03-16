package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.UserCreateDto;
import academy.mindswap.rentacar.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserCreateDto user);

    UserDto getUserById(Long userId);

    UserDto updateUserRoleByToken(String token);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto user);


    void updateUserRole(Long userId);
    void deleteUser(Long userId);
}