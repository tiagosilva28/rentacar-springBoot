package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.UserCreateDto;
import academy.mindswap.rentacar.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserCreateDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto user);


    void deleteUser(Long userId);
}