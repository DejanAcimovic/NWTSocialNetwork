package com.socialnetwork.postModule.PostModule.Repositories;

import java.util.List;

import com.socialnetwork.postModule.PostModule.Entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<PostLike, Long> {
    List<PostLike> findById(Integer id);
}