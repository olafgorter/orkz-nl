package com.orkznl.repository;

import com.orkznl.model.User;
import com.orkznl.model.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    List<UserRole> findByUser(User user);

    List<UserRole> findAll();

}