package com.orkznl.rest;

import com.orkznl.model.UserDTO;
import com.orkznl.usecase.UserUseCase;
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
@RequestMapping("/user")
public class UserRestResource {

    @Autowired private UserUseCase userUseCase;

    private final Logger LOG = LoggerFactory.getLogger("UserRestResource");

    @CrossOrigin
    @RequestMapping("/getallusers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        List<UserDTO> userDTOs = userUseCase.getAllUsers();
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/getUser")
    public ResponseEntity<UserDTO> getUser(@RequestBody String request){

        JSONObject jsonObject = new JSONObject(request);

        Long id = jsonObject.getLong("id");

        UserDTO userDTO = userUseCase.getUser(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody String request) {
        JSONObject jsonObject = new JSONObject(request);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        UserDTO userDTO = userUseCase.login(username, password);

        if(userDTO == null){
            userDTO = new UserDTO();
            userDTO.id = -1L;
        }

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
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
