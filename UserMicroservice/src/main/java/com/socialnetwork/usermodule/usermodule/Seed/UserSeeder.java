package com.socialnetwork.usermodule.usermodule.Seed;

import com.socialnetwork.usermodule.usermodule.Repositories.UserRepository;
import com.socialnetwork.usermodule.usermodule.Repositories.UserGroupRepository;
import com.socialnetwork.usermodule.usermodule.Entities.*;

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

        if (count == 0) {
            userRepository.save(new User("Dejan", "Aćimović"));
            userRepository.save(new User("Adna", "Tucak"));
            userRepository.save(new User("Nađa", "Žilić"));



            for (User user : userRepository.findAll()) {

                //userGroupRepository.save(new UserGroupRepository(user));
                //userGroupRepository.save(new UserGroupRepository(1, user));


            }

        }
    }
}