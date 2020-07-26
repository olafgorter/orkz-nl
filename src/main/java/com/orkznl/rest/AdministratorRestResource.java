package com.orkznl.rest;

import com.orkznl.model.ResidentDTO;
import com.orkznl.model.RoomDTO;
import com.orkznl.model.UserDTO;
import com.orkznl.model.ChargeDTO;
import com.orkznl.usecase.AdministratorUseCase;
import com.orkznl.usecase.UserUseCase;
import com.orkznl.usecase.ChargeUseCase;
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
    @Autowired private ChargeUseCase chargeUseCase;

    private final Logger LOG = LoggerFactory.getLogger("AdministratorRestResource");

    @CrossOrigin
    @RequestMapping("/getResidents")
    public ResponseEntity<List<ResidentDTO>> getResidents(){

        List<ResidentDTO> residentDTOs = administratorUseCase.getResidents();

        return new ResponseEntity<>(residentDTOs, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/getResident")
    public ResponseEntity<ResidentDTO> getResident(@RequestBody Long id){

        ResidentDTO residentDTO = administratorUseCase.getResident(id);

        return new ResponseEntity<>(residentDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping( "/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO){

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

    @CrossOrigin
    @RequestMapping( "/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody String request){

        JSONObject jsonObject = new JSONObject(request);

        Long userId = jsonObject.getLong("userId");

        userUseCase.deleteUser(userId);

        JSONObject response = new JSONObject();
        response.put("result", "deleted");

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping( "/saveCharge")
    public ResponseEntity<String> saveCharge(@RequestBody ChargeDTO chargeDTO){

        if(chargeDTO == null) {
            return new ResponseEntity<String>("", HttpStatus.OK);
        }

        ChargeDTO savedChargeDTO = chargeUseCase.save(chargeDTO);

        JSONObject response = new JSONObject();
        response.put("charge", chargeDTO);

        if(savedChargeDTO == null || savedChargeDTO.id <= 0){
            response.put("saved", "n");
        } else {
            response.put("saved", "y");
        }

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping( "/deleteCharge")
    public ResponseEntity<String> deleteCharge(@RequestBody String request){

        JSONObject jsonObject = new JSONObject(request);

        Long chargeId = jsonObject.getLong("chargeId");

        chargeUseCase.deleteCharge(chargeId);

        JSONObject response = new JSONObject();
        response.put("result", "deleted");

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/getRooms")
    public ResponseEntity<List<RoomDTO>> getRooms(){

        List<RoomDTO> roomDTOs = administratorUseCase.getRooms();

        return new ResponseEntity<>(roomDTOs, HttpStatus.OK);
    }

}
