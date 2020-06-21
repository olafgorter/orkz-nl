package com.orkznl.usecase;

import com.orkznl.model.User;
import com.orkznl.model.UserDTO;
import com.orkznl.model.UserRole;
import com.orkznl.model.UserRoleDTO;
import com.orkznl.repository.UserRepository;
import com.orkznl.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserUseCase {

    @Autowired private UserRepository userRepository;
    @Autowired private UserRoleRepository userRoleRepository;

    @Transactional
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();

        return UserDTO.toDto(users, 2);
    }

    @Transactional
    public UserDTO getUser(Long id){
        User user = userRepository.getById(id);
        List<UserRole> userRoles = userRoleRepository.findByUser(user);

        UserDTO userDTO = UserDTO.toDto(user, 2);
        userDTO.userRoles = UserRoleDTO.toDto(userRoles, 1);
        return userDTO;
    }

    public UserDTO login(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user == null){
            return null;
        }

        if( password.equals(user.getPassword()) ) {
            return UserDTO.toDto(user, 2);
        }
        return null;
    }
    public UserDTO save(UserDTO userDTO) {

        User user = userRepository.findByUsername(userDTO.username);

        if(user == null){
            // dit wordt later de NEW user
            user = new User();
            user.setUsername(userDTO.username);
            user.setEmail(userDTO.email);
            user.setPassword(userDTO.password);

        } else {
            // dit is het updaten van een user
            if (!user.getId().equals(userDTO.id)) {
                return null;
            }

            user.setEmail(userDTO.email);
            user.setPassword(userDTO.password);
        }

        User savedUser = userRepository.save(user);

        System.out.println("user saved: " + UserDTO.toDto(savedUser, 2));

        return UserDTO.toDto(user, 2);
    }
}
