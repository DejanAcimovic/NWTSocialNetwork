package com.socialnetwork.picturemodule.picturemodel.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.socialnetwork.picturemodule.picturemodel.Contracts.ProfilePictureDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.socialnetwork.picturemodule.picturemodel.Entities.*;
import com.socialnetwork.picturemodule.picturemodel.Services.ProfilePicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class ProfilePictureController {

    @Autowired
    private ProfilePicService service;

    @RequestMapping(value="/picture/user/{userId}", method=RequestMethod.GET)
    public @ResponseBody String getProfilePictureByUserId(@PathVariable("userId") Integer userId) {
        try {
            return service.getProfilePictureByUserId(userId);
        }

        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @RequestMapping(value="/pictures/{userId}", method=RequestMethod.POST)
    public @ResponseBody ProfilePicture requestMethodName(@RequestBody ProfilePictureDTO picture) {
        try {
            return service.saveNewProfilePicture(picture.toEntity());
        }

        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @RequestMapping(value="/profilepicture/userId", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@RequestParam(name="userId") Integer userId) {
        try {
            this.service.deleteProfilePicture(userId);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}