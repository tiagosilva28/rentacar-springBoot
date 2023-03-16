package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.UserCreateDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.exceptions.PasswordNotMatch;
import academy.mindswap.rentacar.exceptions.UserDoesntExists;
import academy.mindswap.rentacar.exceptions.UserNotMatch;
import academy.mindswap.rentacar.model.Role;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.TokenRepository;
import academy.mindswap.rentacar.repository.UserRepository;
import academy.mindswap.rentacar.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    @Autowired
    TokenRepository tokenRepository;

    UserConverter userConverter = new UserConverter();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
        if (!userCreateDto.getPassword().equals(userCreateDto.getRetypedPassword())) {
            throw new PasswordNotMatch("Passwords do not match");
        }

        User user = userConverter.fromUserCreateDtoToEntity(userCreateDto);
        user = userRepository.save(user);
        return userConverter.fromUserEntityToUserDto(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        if (!userRepository.existsById(userId)){
            throw new UserDoesntExists("User Doesn't Exists");
        }
        User user = userRepository.getReferenceById(userId);
        User logInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!logInUser.getId().equals(user.getId())){
            throw new UserNotMatch("You are trying to access other User");
        }

        // if user logado != user, throw exception
        return userConverter.fromUserEntityToUserDto(user);
    }

    @Override
    public UserDto updateUserRoleByToken(String token) {

        Long userLoggedId = tokenRepository.findByToken(token).get().getUser().getId();
        User userLogged = userRepository.getReferenceById(userLoggedId);
        userLogged.setRole(Role.ADMIN);
        userRepository.save(userLogged);

        //User user = userRepository.getReferenceById(userId);
      /*  User logInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!logInUser.getId().equals(user.getId())){
            throw new UserNotMatch("You are trying to access other User");
        }

       */

        // if user logado != user, throw exception
        return userConverter.fromUserEntityToUserDto(userLogged);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.parallelStream()
                .map(userConverter::fromUserEntityToUserDto)
                .toList();
        return userDtos;
    }


    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        if (!userRepository.existsById(id)){
            throw new UserDoesntExists("User Doesn't Exists");
        }
        User user = userRepository.getReferenceById(id);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        //user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        return userConverter.fromUserEntityToUserDto(user);
    }


    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)){
            throw new UserDoesntExists("User Doesn't Exists");
        }
        userRepository.deleteById(userId);

    }
}