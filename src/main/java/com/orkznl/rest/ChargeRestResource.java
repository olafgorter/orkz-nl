package com.orkznl.rest;

import com.orkznl.model.ChargeDTO;
import com.orkznl.usecase.ChargeUseCase;
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
@RequestMapping("/charge")
public class ChargeRestResource {

    @Autowired private ChargeUseCase chargeUseCase;

    private final Logger LOG = LoggerFactory.getLogger("ChargeRestResource");

    @RequestMapping("/getAllCharges")
    public ResponseEntity<List<ChargeDTO>> getAllCharges(){

        LOG.debug("Getting all charges");
        System.out.println("Getting all charges");
        List<ChargeDTO> chargeDTOs = chargeUseCase.getAllCharges();

        LOG.debug("Ready getting all charges");
//
//        JSONArray jsonArray =
//        JSONObject response = new JSONObject();
//        response.put("poep", userDTOs.get(0).username);
//        response.put("allah", userDTOs.size());

        return new ResponseEntity<>(chargeDTOs, HttpStatus.OK);
    }

}