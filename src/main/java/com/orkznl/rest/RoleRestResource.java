package com.orkznl.rest;

import com.orkznl.model.RoleDTO;
import com.orkznl.usecase.RoleUseCase;
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
@RequestMapping("/role")
public class RoleRestResource {

    @Autowired private RoleUseCase roleUseCase;

    private final Logger LOG = LoggerFactory.getLogger("RoleRestResource");

    @RequestMapping("/getAllRoles")
    public ResponseEntity<List<RoleDTO>> getAllRoles(){

        LOG.debug("Getting all roles");
        System.out.println("Getting all roles");
        List<RoleDTO> roleDTOs = roleUseCase.getAllRoles();

        LOG.debug("Ready getting all roles");
//
//        JSONArray jsonArray =
//        JSONObject response = new JSONObject();
//        response.put("poep", userDTOs.get(0).username);
//        response.put("allah", userDTOs.size());

        return new ResponseEntity<>(roleDTOs, HttpStatus.OK);
    }

}