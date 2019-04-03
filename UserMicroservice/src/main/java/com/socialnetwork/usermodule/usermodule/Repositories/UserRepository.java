package com.socialnetwork.usermodule.usermodule.Repositories;

import com.socialnetwork.usermodule.usermodule.Entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(Integer userId);
    User findByFirstName(String firstName);


}