package com.orkznl.usecase;

import com.orkznl.model.ChargePrice;
import com.orkznl.model.ChargePriceDTO;
import com.orkznl.repository.ChargePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class ChargePriceUseCase {

    @Autowired
    private ChargePriceRepository chargepriceRepository;

    @Transactional
    public List<ChargePriceDTO> getAllChargePrices(){
        List<ChargePrice> chargeprices = chargepriceRepository.findAll();

        return ChargePriceDTO.toDto(chargeprices);

    }
}