package com.orkznl.usecase;

import com.orkznl.model.User;
import com.orkznl.model.UserDTO;
import com.orkznl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class UserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();

        return UserDTO.toDto(users);

    }
    public UserDTO login(String username, String password){
        User user = userRepository.findByUsername(username);
        if( password.equals(user.getPassword()) ) {
            return UserDTO.toDto(user);
        }
        return null;
    }
}
