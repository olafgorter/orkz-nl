package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class ResidentChargeDTO {
    public Long id;
    public ChargeDTO charge;
    public ResidentDTO resident;
    public Integer version;

    public static List<ResidentChargeDTO> toDto(List<ResidentCharge> residentcharges){
        List<ResidentChargeDTO> residentchargeDTOs = residentcharges.stream().map(ResidentChargeDTO::toDto).collect(Collectors.toList());
        return residentchargeDTOs;
    }

    public static ResidentChargeDTO toDto(ResidentCharge residentcharge){
        ResidentChargeDTO residentchargeDTO = new ResidentChargeDTO();
        residentchargeDTO.id = residentcharge.getId();
        residentchargeDTO.charge = ChargeDTO.toDto(residentcharge.getCharge());
        residentchargeDTO.resident = ResidentDTO.toDto(residentcharge.getResident());
        residentchargeDTO.version = residentcharge.getVersion();

        return residentchargeDTO;
    }

//    @Override
//    public String toString(){
//        return id + " " + chargeDTO.getDescription() + " " + residentDTO.getFull_name();
//    }
}
