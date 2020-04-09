package com.orkznl.usecase;

import com.orkznl.model.Resident;
import com.orkznl.model.ResidentDTO;
import com.orkznl.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class ResidentUseCase {

    @Autowired
    private ResidentRepository residentRepository;

    @Transactional
    public List<ResidentDTO> getAllResidents(){
        List<Resident> residents = residentRepository.findAll();

        return ResidentDTO.toDto(residents);

    }
}