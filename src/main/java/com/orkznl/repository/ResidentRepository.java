package com.orkznl.repository;

import com.orkznl.model.Resident;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResidentRepository extends CrudRepository<Resident, Long> {

    List<Resident> findByFullName(String fullName);

    List<Resident> findAll();

}