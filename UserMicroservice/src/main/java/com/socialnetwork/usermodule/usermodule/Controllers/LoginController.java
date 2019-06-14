package com.socialnetwork.usermodule.usermodule.Controllers;

import javax.persistence.EntityNotFoundException;

import com.socialnetwork.usermodule.usermodule.Contracts.LoginDTO;
import com.socialnetwork.usermodule.usermodule.Services.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginController
 */
@RestController
public class LoginController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO login) {
        return new ResponseEntity<>(service.generateJWTToken(login.username, login.password), HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
}