package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class RoleDTO {
    public Long id;
    public String description;
    public Integer version;

    public static List<RoleDTO> toDto(List<Role> roles){
        List<RoleDTO> roleDTOs = roles.stream().map(RoleDTO::toDto).collect(Collectors.toList());
        return roleDTOs;
    }

    public static RoleDTO toDto(Role role){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.id = role.getId();
        roleDTO.description = role.getDescription();
        roleDTO.version = role.getVersion();

        return roleDTO;
    }

    @Override
    public String toString(){return id + " " + description;
    }
}
