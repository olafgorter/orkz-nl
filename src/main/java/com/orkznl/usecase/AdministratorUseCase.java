package com.orkznl.usecase;

import com.orkznl.model.Resident;
import com.orkznl.model.ResidentDTO;
import com.orkznl.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class AdministratorUseCase {

    @Autowired
    private ResidentRepository residentRepository;

    @Transactional
    public List<ResidentDTO> getResidents(){

        List<Resident> residents = residentRepository.findAll();
        return ResidentDTO.toDto(residents);
    }

    @Transactional
    public ResidentDTO getResident(Long id){

        Resident resident = residentRepository.getById(id);
        return ResidentDTO.toDto(resident);
    }

}
