package com.socialnetwork.userModule.UserModule.Repositories;

import com.socialnetwork.userModule.UserModule.Entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendListRepository extends CrudRepository<User, Long> {
}