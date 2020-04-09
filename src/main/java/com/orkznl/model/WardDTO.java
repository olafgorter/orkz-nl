package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class WardDTO {
    public Long id;
    public String description;
    public Integer sortorder;
    public Integer version;

    public static List<WardDTO> toDto(List<Ward> wards){
        List<WardDTO> WardDTOs = wards.stream().map(WardDTO::toDto).collect(Collectors.toList());
        return WardDTOs;
    }

    public static WardDTO toDto(Ward ward){
        WardDTO wardDTO = new WardDTO();
        wardDTO.id = ward.getId();
        wardDTO.description = ward.getDescription();
        wardDTO.sortorder = ward.getSortorder();
        wardDTO.version = ward.getVersion();

        return wardDTO;
    }

    @Override
    public String toString(){ return "Ward: " + id + " " + description + " " + sortorder; }
}
