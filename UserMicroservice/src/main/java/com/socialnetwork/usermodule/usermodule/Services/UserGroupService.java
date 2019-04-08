package com.socialnetwork.usermodule.usermodule.Services;


import com.socialnetwork.usermodule.usermodule.Entities.User;
import com.socialnetwork.usermodule.usermodule.Entities.UserGroup;
import com.socialnetwork.usermodule.usermodule.Repositories.UserGroupRepository;
import com.socialnetwork.usermodule.usermodule.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService {

    private UserGroupRepository repository;
    private UserRepository userRepository;

    @Autowired
    public UserGroupService(UserGroupRepository _repository){
        this.repository = _repository;
    }



    public UserGroup saveNewGroup (UserGroup group){
        this.repository.save(group);
        return group;
    }

    public void addNewUserToGroup (Integer user_id, Integer group_id) throws Exception{

        UserGroup group = this.repository.findById(group_id);
        User user = this.userRepository.findById(user_id);

        if(group == null){
            throw new Exception("No group with given id found");
        }

        if(user == null){
            throw new Exception("No user with given id found");
        }

        group.getUsers().add(user);

    }


    public void deleteGroup(Integer groupId) throws Exception {
        UserGroup group = this.repository.findById(groupId);

        if(group == null){
            throw new Exception("Group with this id does not exist");
        }

        this.repository.delete(group);
    }
}
