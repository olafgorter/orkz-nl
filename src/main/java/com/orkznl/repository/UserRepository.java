package com.orkznl.repository;

import com.orkznl.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);


    List<User> findAll();

}
