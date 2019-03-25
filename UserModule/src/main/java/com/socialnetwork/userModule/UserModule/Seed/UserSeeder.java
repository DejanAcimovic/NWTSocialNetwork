package com.socialnetwork.userModule.UserModule.Seed;

import com.socialnetwork.userModule.UserModule.Repositories.UserRepository;
import com.socialnetwork.userModule.UserModule.Repositories.UserGroupRepository;

import java.util.ArrayList;
import java.util.List;

import com.socialnetwork.userModule.UserModule.Entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder implements ApplicationRunner {

    private UserRepository userRepository;
    private UserGroupRepository userGroupRepository;
   

    @Autowired
    public UserSeeder(UserRepository _userRepository, UserGroupRepository _userGroupRepository) {
        this.userGroupRepository = _userGroupRepository;
        this.userRepository = _userRepository;

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = userRepository.count();
        
        if(count == 0) {
            userRepository.save(new User("Dejan","Aćimović"));
            userRepository.save(new User("Adna","Tucak"));
            userRepository.save(new User("Nađa","Žilić"));

            UserGroup newGroup = new UserGroup("Grupa1", null);

            userGroupRepository.save(newGroup);
    
            for (User user : userRepository.findAll()) {
                for(UserGroup group: userGroupRepository.findAll()){
                    user.addUserGorup(group);
                    userRepository.save(user);
                }
            }


        }
    }
}