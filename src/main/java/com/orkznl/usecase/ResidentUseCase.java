package com.orkznl.usecase;

import com.orkznl.model.*;
import com.orkznl.repository.ChargeRepository;
import com.orkznl.repository.ResidentChargeRepository;
import com.orkznl.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ResidentUseCase {

    @Autowired
    private ResidentRepository residentRepository;

    @Autowired
    private ResidentChargeRepository residentChargeRepository;

    @Transactional
    public List<ResidentDTO> getAllResidents(){
        List<Resident> residents = residentRepository.findAll();

        return ResidentDTO.toDto(residents);
    }

    @Transactional
    public ResidentDTO getById(Long id){
        Resident resident = residentRepository.getById(id);

        return ResidentDTO.toDto(resident);
    }

    @Transactional
    public List<ResidentChargeDTO> getChargesByResident(Long residentId){

        List<ResidentCharge> charges = residentChargeRepository.findByResident_Id(residentId);

        return ResidentChargeDTO.toDto(charges);

    }


}