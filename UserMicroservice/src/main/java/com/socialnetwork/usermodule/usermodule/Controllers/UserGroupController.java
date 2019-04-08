package com.socialnetwork.usermodule.usermodule.Controllers;

import com.socialnetwork.usermodule.usermodule.Contracts.AddUserToGroupDTO;
import com.socialnetwork.usermodule.usermodule.Contracts.UserDTO;
import com.socialnetwork.usermodule.usermodule.Contracts.UserGroupDTO;
import com.socialnetwork.usermodule.usermodule.Entities.User;
import com.socialnetwork.usermodule.usermodule.Entities.UserGroup;
import com.socialnetwork.usermodule.usermodule.Services.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserGroupController {
    @Autowired
    private UserGroupService service;


    @RequestMapping(value="/group", method=RequestMethod.POST)
    public @ResponseBody UserGroup requestMethodName(@RequestBody UserGroupDTO group_dto) {
        try{
            return service.saveNewGroup(group_dto.toEntity());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @RequestMapping(value = "/group/member",method = RequestMethod.POST)
    public ResponseEntity<String> addNewUserToGroup(@RequestBody AddUserToGroupDTO addDTO){
        try {
            this.service.addNewUserToGroup(addDTO.user_id, addDTO.group_id);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @RequestMapping(value="/user_group/groupId", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteGroup(@RequestParam(name="groupId") Integer groupId) {
        try {
            this.service.deleteGroup(groupId);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
