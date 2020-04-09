package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class RoomDTO {
    public Long id;
    public WardDTO wardDTO;
    public Integer roomnumber;
    public Integer version;

    public static List<RoomDTO> toDto(List<Room> rooms){
        List<RoomDTO> roomDTOs = rooms.stream().map(RoomDTO::toDto).collect(Collectors.toList());
        return roomDTOs;
    }

    public static RoomDTO toDto(Room room){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.id = room.getId();
        roomDTO.wardDTO = WardDTO.toDto( room.getWard());
        roomDTO.roomnumber = room.getRoomnumber();
        roomDTO.version = room.getVersion();

        return roomDTO;
    }

    @Override
    public String toString(){ return "Room: " + id + " " + wardDTO.description + " " + roomnumber; }
}
