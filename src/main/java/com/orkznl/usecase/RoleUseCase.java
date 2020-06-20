package com.orkznl.usecase;

import com.orkznl.model.Role;
import com.orkznl.model.RoleDTO;
import com.orkznl.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class RoleUseCase {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public List<RoleDTO> getAllRoles(){
        List<Role> roles = roleRepository.findAll();

        return RoleDTO.toDto(roles);

    }
}
