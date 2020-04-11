package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    public Long id;
    public String username;
    public String password;
    public String email;
    public ResidentDTO residentDTO;
    public Integer version;

    public static List<UserDTO> toDto(List<User> users){
        List<UserDTO> userDTOs = users.stream().map(UserDTO::toDto).collect(Collectors.toList());

        System.out.println(userDTOs.size());

        return userDTOs;
    }

    public static UserDTO toDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.id = user.getId();
        userDTO.username = user.getUsername();
        userDTO.password = user.getPassword();
        userDTO.email = user.getEmail();
        userDTO.residentDTO =  ResidentDTO.toDto( user.getResident());
        userDTO.version = user.getVersion();

        return userDTO;
    }

    @Override
    public String toString(){
        return id + " " + username + " " + password + " " + email;
    }
}
