package com.orkznl.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ChargePriceDTO {
    public Long id;
    public ChargeDTO chargeDTO;
    public Double price;
    public Date start_date;
    public Date end_date;
    public Integer version;

    public static List<ChargePriceDTO> toDto(List<ChargePrice> chargeprices){
        List<ChargePriceDTO> chargepriceDTOs = chargeprices.stream().map(ChargePriceDTO::toDto).collect(Collectors.toList());
        return chargepriceDTOs;
    }

    public static ChargePriceDTO toDto(ChargePrice chargeprice){
        ChargePriceDTO chargepriceDTO = new ChargePriceDTO();
        chargepriceDTO.id = chargeprice.getId();
        chargepriceDTO.chargeDTO = ChargeDTO.toDto(chargeprice.getCharge());
        chargepriceDTO.price = chargeprice.getPrice();
        chargepriceDTO.start_date = chargeprice.getStart_date();
        chargepriceDTO.end_date = chargeprice.getEnd_date();
        chargepriceDTO.version = chargeprice.getVersion();

        return chargepriceDTO;
    }

    @Override
    public String toString(){
        return id + " " + chargeDTO.description + " " + price + " " + start_date + " " + end_date;
    }
}
