package com.orkznl.rest;

import com.orkznl.model.RoomDTO;
import com.orkznl.usecase.RoomUseCase;
import org.apache.juli.logging.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/room")
public class RoomRestResource {

    @Autowired private RoomUseCase roomUseCase;

    private final Logger LOG = LoggerFactory.getLogger("RoomRestResource");

    @RequestMapping("/getAllRooms")
    public ResponseEntity<List<RoomDTO>> getAllRooms(){

        LOG.debug("Getting all rooms");
        System.out.println("Getting all rooms");
        List<RoomDTO> roomDTOs = roomUseCase.getAllRooms();

        LOG.debug("Ready getting all rooms");
//
//        JSONArray jsonArray =
//        JSONObject response = new JSONObject();
//        response.put("poep", userDTOs.get(0).username);
//        response.put("allah", userDTOs.size());

        return new ResponseEntity<>(roomDTOs, HttpStatus.OK);
    }

}