package com.orkznl.repository;

import com.orkznl.model.Charge;
import com.orkznl.model.ChargePrice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChargePriceRepository extends CrudRepository<ChargePrice, Long> {

    List<ChargePrice> findByCharge(Charge charge);

    List<ChargePrice> findAll();

}