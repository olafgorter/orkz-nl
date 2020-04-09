package com.orkznl.repository;

import com.orkznl.model.Payment;
import com.orkznl.model.Resident;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findByResident(Resident resident);

    List<Payment> findAll();

}