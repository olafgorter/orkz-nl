package com.orkznl.rest;

import com.orkznl.model.PaymentDTO;
import com.orkznl.model.UserDTO;
import com.orkznl.usecase.PaymentUseCase;
import com.orkznl.usecase.UserUseCase;
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
@RequestMapping("/payment")
public class PaymentRestResource {

    @Autowired private PaymentUseCase paymentUseCase;

    private final Logger LOG = LoggerFactory.getLogger("PaymentRestResource");

    @RequestMapping("/getAllPayments")
    public ResponseEntity<List<PaymentDTO>> getAllPayments(){

        LOG.debug("Getting all payments");
        System.out.println("Getting all payments");
        List<PaymentDTO> paymentDTOs = paymentUseCase.getAllPayments();

        LOG.debug("Ready getting all payments");
//
//        JSONArray jsonArray =
//        JSONObject response = new JSONObject();
//        response.put("poep", userDTOs.get(0).username);
//        response.put("allah", userDTOs.size());

        return new ResponseEntity<>(paymentDTOs, HttpStatus.OK);
    }

}
