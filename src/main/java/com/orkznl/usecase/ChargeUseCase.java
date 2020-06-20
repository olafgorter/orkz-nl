package com.orkznl.usecase;

import com.orkznl.model.Charge;
import com.orkznl.model.ChargeDTO;
import com.orkznl.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ChargeUseCase {

    @Autowired
    private ChargeRepository chargeRepository;

    @Transactional
    public List<ChargeDTO> getAllCharges(){
        List<Charge> charges = chargeRepository.findAll();

        return ChargeDTO.toDto(charges);

    }
}