package com.orkznl.repository;

import com.orkznl.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findByWard(Integer ward);

    List<Room> findAll();

}
