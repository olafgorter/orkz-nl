package com.orkznl.rest;

import com.orkznl.model.WardDTO;
import com.orkznl.usecase.WardUseCase;
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
@RequestMapping("/ward")
public class WardRestResource {

    @Autowired private WardUseCase wardUseCase;

    private final Logger LOG = LoggerFactory.getLogger("WardRestResource");

    @RequestMapping("/getAllWards")
    public ResponseEntity<List<WardDTO>> getAllWards(){

        LOG.debug("Getting all wards");
        System.out.println("Getting all wards");
        List<WardDTO> wardDTOs = wardUseCase.getAllWards();

        LOG.debug("Ready getting all wards");
//
//        JSONArray jsonArray =
//        JSONObject response = new JSONObject();
//        response.put("poep", userDTOs.get(0).username);
//        response.put("allah", userDTOs.size());

        return new ResponseEntity<>(wardDTOs, HttpStatus.OK);
    }

}