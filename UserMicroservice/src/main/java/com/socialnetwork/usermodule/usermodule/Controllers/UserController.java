package com.socialnetwork.usermodule.usermodule.Controllers;


import com.socialnetwork.usermodule.usermodule.Contracts.AddFriendDTO;
import com.socialnetwork.usermodule.usermodule.Contracts.UserDTO;
import com.socialnetwork.usermodule.usermodule.Entities.User;
import com.socialnetwork.usermodule.usermodule.Entities.UserGroup;
import com.socialnetwork.usermodule.usermodule.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController 
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "get/user/user_id",method = RequestMethod.GET)
    public @ResponseBody
    User getUserById(@RequestParam("userId") Integer userId){
       try{
           return service.getUserById(userId);
       }
       catch (Exception e){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
       }

    }

    @RequestMapping(value = "get/user/{first_name}",method = RequestMethod.GET)
    public @ResponseBody
    User getUserByFirstName(@RequestParam("firstName") String firstName){
        try {
            return service.getUserByFirstName(firstName);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @RequestMapping(value = "get/users",method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUserFriends(@RequestParam("users") Integer users){

        try {
            return service.getUserFriends(users);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @RequestMapping(value = "get/usergroups/{user_id}",method = RequestMethod.GET)
    public @ResponseBody
    List<UserGroup> getAllGroupsOfUser(@RequestParam("userId") Integer userId){
        return service.getAllGroupsOfUser(userId);
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    public @ResponseBody User requestMethodName(@RequestBody UserDTO user_dto) {
        try {
            return service.saveNewUser(user_dto.toEntity(),user_dto.url);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @RequestMapping(value="/user/friend", method=RequestMethod.POST)
    public ResponseEntity<String> requestMethodName(@RequestBody AddFriendDTO friendUser_dto) {
        try
        {
            this.service.addFriend(friendUser_dto.user_id,friendUser_dto.friend_id);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @RequestMapping(value="/user/userId", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@RequestParam(name="userId") Integer userId) {
        try {
            this.service.deleteUser(userId);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }





}
