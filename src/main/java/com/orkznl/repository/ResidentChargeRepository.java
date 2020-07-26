package com.orkznl.repository;

import com.orkznl.model.Charge;
import com.orkznl.model.ResidentCharge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResidentChargeRepository extends CrudRepository<ResidentCharge, Long> {

    List<ResidentCharge> findByCharge(Charge charge);

    List<ResidentCharge> findAll();

    List<ResidentCharge> findByResident_Id(Long residentId);

}
