package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class ChargeDTO {
    public Long id;
    public String description;
    public Integer version;

    public static List<ChargeDTO> toDto(List<Charge> charges){
        List<ChargeDTO> chargeDTOs = charges.stream().map(ChargeDTO::toDto).collect(Collectors.toList());
        return chargeDTOs;
    }

    public static ChargeDTO toDto(Charge charge){
        ChargeDTO chargeDTO = new ChargeDTO();
        chargeDTO.id = charge.getId();
        chargeDTO.description = charge.getDescription();
        chargeDTO.version = charge.getVersion();

        return chargeDTO;
    }

    @Override
    public String toString(){
        return id + " " + description;
    }
}