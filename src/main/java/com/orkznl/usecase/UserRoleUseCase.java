package com.orkznl.usecase;

import com.orkznl.model.UserRole;
import com.orkznl.model.UserRoleDTO;
import com.orkznl.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class UserRoleUseCase {

    @Autowired
    private UserRoleRepository userroleRepository;

    @Transactional
    public List<UserRoleDTO> getAllUserroles(){
        List<UserRole> userroles = userroleRepository.findAll();

        return UserRoleDTO.toDto(userroles);

    }
}
