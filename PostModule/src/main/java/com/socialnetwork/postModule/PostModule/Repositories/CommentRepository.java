package com.socialnetwork.postModule.PostModule.Repositories;

import java.util.List;

import com.socialnetwork.postModule.PostModule.Entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findById(Integer id);
}