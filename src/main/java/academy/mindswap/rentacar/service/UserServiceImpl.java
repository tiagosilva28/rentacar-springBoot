package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
   /* @Override
    public User getUser() {



        return User.builder()
                .id(1L)
                .firstName("Tiago")
                .lastName("Silva")
                .email("tiagosilva28@live.com.pt")
                .build();

    }

    */
}
