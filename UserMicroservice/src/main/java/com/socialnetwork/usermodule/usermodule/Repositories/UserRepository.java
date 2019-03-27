package com.socialnetwork.usermodule.usermodule.Repositories;

import com.socialnetwork.usermodule.usermodule.Entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}