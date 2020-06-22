package com.orkznl.repository;

import com.orkznl.model.Charge;
import com.orkznl.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChargeRepository extends CrudRepository<Charge, Long> {

  // List<Charge> findByDescription(String description);
    Charge findByDescription(String description);
    List<Charge> findAll();

    Charge getById(Long id);

}
