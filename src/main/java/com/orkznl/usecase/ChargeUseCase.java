package com.orkznl.usecase;

import com.orkznl.model.*;
import com.orkznl.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    @Transactional
    public ChargeDTO save(ChargeDTO chargeDTO) {

        Charge charge = chargeDTO.id != null ? chargeRepository.getById(chargeDTO.id): null;

        if(charge == null){
            // dit wordt later de NEW charge
            charge = new Charge();
            charge.setDescription(chargeDTO.description);

        } else {
            charge.setDescription(chargeDTO.description);
        }

        Charge savedCharge = chargeRepository.save(charge);

        return ChargeDTO.toDto(savedCharge);
    }

    @Transactional
    public void deleteCharge(Long id) {
        chargeRepository.deleteById(id);
    }
}