package com.orkznl.rest;

import com.orkznl.model.ChargeDTO;
import com.orkznl.model.ResidentChargeDTO;
import com.orkznl.model.ResidentDTO;
import com.orkznl.usecase.ResidentUseCase;
import org.apache.juli.logging.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/resident")
public class ResidentRestResource {

    @Autowired private ResidentUseCase residentUseCase;

    private final Logger LOG = LoggerFactory.getLogger("ResidentRestResource");

    @CrossOrigin
    @RequestMapping("/getAllResidents")
    public ResponseEntity<List<ResidentDTO>> getAllResidents(){

        LOG.debug("Getting all residents");
        System.out.println("Getting all residents");
        List<ResidentDTO> residentDTOs = residentUseCase.getAllResidents();

        LOG.debug("Ready getting all residents");
//
//        JSONArray jsonArray =
//        JSONObject response = new JSONObject();
//        response.put("poep", userDTOs.get(0).username);
//        response.put("allah", userDTOs.size());

        return new ResponseEntity<>(residentDTOs, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/getResident")
    public ResponseEntity<ResidentDTO> getResident(Long id){

        ResidentDTO residentDTO = residentUseCase.getById(id);
        return new ResponseEntity<>(residentDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/getChargesByResident")
    public ResponseEntity<List<ResidentChargeDTO>> getChargesByResident(@RequestBody String request){

        JSONObject jsonObject = new JSONObject(request);
        Long residentId = jsonObject.getLong("residentId");

        List<ResidentChargeDTO> residentChargeDTOs = residentUseCase.getChargesByResident(residentId);

        return new ResponseEntity<>(residentChargeDTOs, HttpStatus.OK);
    }


}