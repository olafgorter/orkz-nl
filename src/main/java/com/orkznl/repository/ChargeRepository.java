package com.orkznl.repository;

import com.orkznl.model.Charge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChargeRepository extends CrudRepository<Charge, Long> {

    List<Charge> findByDescription(String description);

    List<Charge> findAll();

}
