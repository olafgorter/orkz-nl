package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserRoleDTO {
    public Long id;
    public UserDTO user;
    public RoleDTO role;
    public Integer version;

    public static List<UserRoleDTO> toDto(List<UserRole> userroles, int level){
        List<UserRoleDTO> userroleDTOs = userroles.stream().map(userRole -> UserRoleDTO.toDto(userRole,level)).collect(Collectors.toList());
        return userroleDTOs;
    }

    public static UserRoleDTO toDto(UserRole userRole, int level){
        level--;
        UserRoleDTO userroleDTO = new UserRoleDTO();
        userroleDTO.id = userRole.getId();
        userroleDTO.version = userRole.getVersion();

        if(level >= 0) {
            userroleDTO.user = UserDTO.toDto(userRole.getUser(), level);
            userroleDTO.role = RoleDTO.toDto(userRole.getRole());
        }

        return userroleDTO;
    }

    @Override
    public String toString(){
        return id + " " + user.username + " " + role.description;
    }
}