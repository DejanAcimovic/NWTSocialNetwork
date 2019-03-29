package com.socialnetwork.usermodule.usermodule.Repositories;

import com.socialnetwork.usermodule.usermodule.Entities.*;
import io.swagger.models.auth.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository extends CrudRepository<UserGroup, Long> {
    UserGroup findById(Integer group_id);
}