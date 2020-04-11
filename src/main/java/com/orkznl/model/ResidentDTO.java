package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class ResidentDTO {
    public Long id;
    public String fullName;
    public RoomDTO room;
    public String bankAccount;
    public Integer version;

    public static List<ResidentDTO> toDto(List<Resident> residents){
        List<ResidentDTO> residentDTOs = residents.stream().map(ResidentDTO::toDto).collect(Collectors.toList());
        return residentDTOs;
    }

    public static ResidentDTO toDto(Resident resident){
        ResidentDTO residentDTO = new ResidentDTO();
        residentDTO.id = resident.getId();
        residentDTO.fullName = resident.getFullName();
        residentDTO.room = RoomDTO.toDto(resident.getRoom());
        residentDTO.bankAccount = resident.getBankAccount();
        residentDTO.version = resident.getVersion();

        return residentDTO;
    }

    @Override
    public String toString(){ return "Resident: " + id + " " + fullName + " " + room.ward + " " + bankAccount; }
}