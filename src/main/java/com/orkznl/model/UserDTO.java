package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    public Long id;
    public String username;
    public String password;
    public String email;
    public Integer version;

    public ResidentDTO resident;

    public List<UserRoleDTO> userRoles;

    public static List<UserDTO> toDto(List<User> users, int level){
        List<UserDTO> userDTOs = users.stream().map(user -> UserDTO.toDto(user,level)).collect(Collectors.toList());

        System.out.println(userDTOs.size());

        return userDTOs;
    }

    public static UserDTO toDto(User user, int level){
        level--;

        UserDTO userDTO = new UserDTO();
        userDTO.id = user.getId();
        userDTO.username = user.getUsername();
        userDTO.password = user.getPassword();
        userDTO.email = user.getEmail();
        userDTO.version = user.getVersion();

        if(level > 0) {
            userDTO.resident = ResidentDTO.toDto(user.getResident());
        }

        return userDTO;
    }

    @Override
    public String toString(){
        return id + " " + username + " " + password + " " + email;
    }
}
