package com.orkznl.model;

import java.util.List;
import java.util.stream.Collectors;

public class RoomDTO {
    public Long id;
    public WardDTO ward;
    public Integer roomNumber;
    public Integer version;

    public static List<RoomDTO> toDto(List<Room> rooms){
        List<RoomDTO> roomDTOs = rooms.stream().map(RoomDTO::toDto).collect(Collectors.toList());
        return roomDTOs;
    }

    public static RoomDTO toDto(Room room){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.id = room.getId();
        roomDTO.ward = WardDTO.toDto( room.getWard());
        roomDTO.roomNumber = room.getRoomnumber();
        roomDTO.version = room.getVersion();

        return roomDTO;
    }

    @Override
    public String toString(){ return "Room: " + id + " " + ward.description + " " + roomNumber; }
}
