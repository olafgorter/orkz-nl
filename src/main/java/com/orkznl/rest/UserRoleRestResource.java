package com.orkznl.rest;

import com.orkznl.model.UserRoleDTO;
import com.orkznl.usecase.UserRoleUseCase;
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
@RequestMapping("/userrole")
public class UserRoleRestResource {

    @Autowired private UserRoleUseCase userroleUseCase;

    private final Logger LOG = LoggerFactory.getLogger("UserRoleRestResource");

    @RequestMapping("/getAllUserRoles")
    public ResponseEntity<List<UserRoleDTO>> getAllUserroles(){

        LOG.debug("Getting all userroles");
        System.out.println("Getting all userroles");
        List<UserRoleDTO> userroleDTOs = userroleUseCase.getAllUserroles();

        LOG.debug("Ready getting all userroles");
//
//        JSONArray jsonArray =
//        JSONObject response = new JSONObject();
//        response.put("poep", userDTOs.get(0).username);
//        response.put("allah", userDTOs.size());

        return new ResponseEntity<>(userroleDTOs, HttpStatus.OK);
    }

}