package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class ResidentDTO {
    public Long id;
    public String full_name;
    public RoomDTO roomDTO;
    public String bank_account;
    public Integer version;

    public static List<ResidentDTO> toDto(List<Resident> residents){
        List<ResidentDTO> residentDTOs = residents.stream().map(ResidentDTO::toDto).collect(Collectors.toList());
        return residentDTOs;
    }

    public static ResidentDTO toDto(Resident resident){
        ResidentDTO residentDTO = new ResidentDTO();
        residentDTO.id = resident.getId();
        residentDTO.full_name = resident.getFullName();
        residentDTO.roomDTO= RoomDTO.toDto(resident.getRoom());
        residentDTO.bank_account = resident.getBankAccount();
        residentDTO.version = resident.getVersion();

        return residentDTO;
    }

    @Override
    public String toString(){ return "Resident: " + id + " " + full_name + " " + roomDTO.wardDTO  + " " + bank_account; }
}