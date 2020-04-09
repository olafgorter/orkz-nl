package com.orkznl.rest;

import com.orkznl.model.ResidentChargeDTO;
import com.orkznl.usecase.ResidentChargeUseCase;
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
@RequestMapping("/residentcharge")
public class ResidentChargeRestResource {

    @Autowired private ResidentChargeUseCase residentchargeUseCase;

    private final Logger LOG = LoggerFactory.getLogger("ResidentChargeRestResource");

    @RequestMapping("/getAllResidentcharges")
    public ResponseEntity<List<ResidentChargeDTO>> getAllResidentcharges(){

        LOG.debug("Getting all residentcharges");
        System.out.println("Getting all residentcharges");
        List<ResidentChargeDTO> residentchargeDTOs = residentchargeUseCase.getAllResidentCharges();

        LOG.debug("Ready getting all residentcharges");
//
//        JSONArray jsonArray =
//        JSONObject response = new JSONObject();
//        response.put("poep", userDTOs.get(0).username);
//        response.put("allah", userDTOs.size());

        return new ResponseEntity<>(residentchargeDTOs, HttpStatus.OK);
    }

}