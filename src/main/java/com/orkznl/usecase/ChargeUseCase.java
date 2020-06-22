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

    public ChargeDTO save(ChargeDTO chargeDTO) {

        Charge charge = chargeRepository.findByDescription(chargeDTO.description);

        if(charge == null){
            // dit wordt later de NEW charge
            charge = new Charge();
            charge.setDescription(chargeDTO.description);

        } else {
            // dit is het updaten van een charge
            if (!charge.getId().equals(chargeDTO.id)) {
                return null;
            }

        }

        Charge savedCharge = chargeRepository.save(charge);

        System.out.println("charge saved: " + ChargeDTO.toDto(savedCharge));

        ChargeDTO savedChargeDTO = ChargeDTO.toDto(charge);

        return savedChargeDTO;
    }

    public void deleteCharge(Long id) {
        chargeRepository.deleteById(id);
    }
}