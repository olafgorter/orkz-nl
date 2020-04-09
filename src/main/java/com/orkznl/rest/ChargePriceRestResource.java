package com.orkznl.rest;

import com.orkznl.model.ChargePriceDTO;
import com.orkznl.usecase.ChargePriceUseCase;
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
@RequestMapping("/chargeprice")
public class ChargePriceRestResource {

    @Autowired private ChargePriceUseCase chargepriceUseCase;

    private final Logger LOG = LoggerFactory.getLogger("ChargePriceRestResource");

    @RequestMapping("/getAllChargeprices")
    public ResponseEntity<List<ChargePriceDTO>> getAllChargeprices(){

        LOG.debug("Getting all chargeprices");
        System.out.println("Getting all chargeprices");
        List<ChargePriceDTO> chargepriceDTOs = chargepriceUseCase.getAllChargePrices();

        LOG.debug("Ready getting all chargeprices");
//
//        JSONArray jsonArray =
//        JSONObject response = new JSONObject();
//        response.put("poep", userDTOs.get(0).username);
//        response.put("allah", userDTOs.size());

        return new ResponseEntity<>(chargepriceDTOs, HttpStatus.OK);
    }

}