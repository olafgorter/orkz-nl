package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserRoleDTO {
    public Long id;
    public UserDTO userDTO;
    public RoleDTO roleDTO;
    public Integer version;

    public static List<UserRoleDTO> toDto(List<UserRole> userrols){
        List<UserRoleDTO> userroleDTOs = userrols.stream().map(UserRoleDTO::toDto).collect(Collectors.toList());
        return userroleDTOs;
    }

    public static UserRoleDTO toDto(UserRole userrole){
        UserRoleDTO userroleDTO = new UserRoleDTO();
        userroleDTO.id = userrole.getId();
        userroleDTO.userDTO = UserDTO.toDto( userrole.getUser());
        userroleDTO.roleDTO = RoleDTO.toDto( userrole.getRole());
        userroleDTO.version = userrole.getVersion();

        return userroleDTO;
    }

    @Override
    public String toString(){
        return id + " " + userDTO.username + " " + roleDTO.description;
    }
}