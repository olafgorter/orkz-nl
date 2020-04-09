package com.orkznl.repository;

import com.orkznl.model.Ward;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WardRepository extends CrudRepository<Ward, Long> {

    List<Ward> findByDescription(String description);

    List<Ward> findAll();

}