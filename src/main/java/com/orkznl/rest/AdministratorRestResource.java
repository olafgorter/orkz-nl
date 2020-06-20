package com.orkznl.rest;

import com.orkznl.model.ResidentDTO;
import com.orkznl.model.UserDTO;
import com.orkznl.usecase.AdministratorUseCase;
import com.orkznl.usecase.UserUseCase;
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
@RequestMapping("/administrator")
public class AdministratorRestResource {

    @Autowired private UserUseCase userUseCase;
    @Autowired private AdministratorUseCase administratorUseCase;

    private final Logger LOG = LoggerFactory.getLogger("AdministratorRestResource");

    @CrossOrigin
    @RequestMapping("/getResidents")
    public ResponseEntity<List<ResidentDTO>> getResidents(){

        List<ResidentDTO> residentDTOs = administratorUseCase.getResidents();

        return new ResponseEntity<>(residentDTOs, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping( "/save")
    public ResponseEntity<String> save(@RequestBody UserDTO userDTO){

        if(userDTO == null) {
            return new ResponseEntity<String>("", HttpStatus.OK);
        }

        UserDTO savedUserDTO = userUseCase.save(userDTO);

        JSONObject response = new JSONObject();
        response.put("user", userDTO);

        if(savedUserDTO == null || savedUserDTO.id <= 0){
            response.put("saved", "n");
        } else {
            response.put("saved", "y");
        }

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }
}
