package com.orkznl.repository;

import com.orkznl.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findByDescription(String description);

    List<Role> findAll();

}