package com.orkznl.usecase;

import com.orkznl.model.Room;
import com.orkznl.model.RoomDTO;
import com.orkznl.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class RoomUseCase {

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    public List<RoomDTO> getAllRooms(){
        List<Room> rooms = roomRepository.findAll();

        return RoomDTO.toDto(rooms);

    }
}