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

    @RequestMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        LOG.debug("Getting all users");
        System.out.println("Getting all users");
        List<UserDTO> userDTOs = userUseCase.getAllUsers();

        LOG.debug("Ready getting all users");
//
//        JSONArray jsonArray =
//        JSONObject response = new JSONObject();
//        response.put("poep", userDTOs.get(0).username);
//        response.put("allah", userDTOs.size());

        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/login")
    public ResponseEntity<String> login(@RequestBody String request) {
        JSONObject jsonObject = new JSONObject(request);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        UserDTO userDTO = userUseCase.login(username, password);

        String loggedIn = userDTO == null ? "Login credentials incorrect" : "Login OK";

        JSONObject response = new JSONObject();
        response.put("result", loggedIn);

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }
}
