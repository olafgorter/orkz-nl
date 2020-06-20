package com.orkznl.usecase;

import com.orkznl.model.ResidentCharge;
import com.orkznl.model.ResidentChargeDTO;
import com.orkznl.repository.ResidentChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ResidentChargeUseCase {

    @Autowired
    private ResidentChargeRepository residentchargeRepository;

    @Transactional
    public List<ResidentChargeDTO> getAllResidentCharges(){
        List<ResidentCharge> residentcharges = residentchargeRepository.findAll();

        return ResidentChargeDTO.toDto(residentcharges);

    }
}