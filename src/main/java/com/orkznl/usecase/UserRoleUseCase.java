package com.orkznl.usecase;

import com.orkznl.model.UserRole;
import com.orkznl.model.UserRoleDTO;
import com.orkznl.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserRoleUseCase {

    @Autowired
    private UserRoleRepository userroleRepository;

    @Transactional
    public List<UserRoleDTO> getAllUserroles(){
        List<UserRole> userroles = userroleRepository.findAll();

        return UserRoleDTO.toDto(userroles, 2);

    }
}
