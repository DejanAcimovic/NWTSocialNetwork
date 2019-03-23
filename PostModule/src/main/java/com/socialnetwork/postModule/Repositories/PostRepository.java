package com.socialnetwork.postModule.Repositories;

import java.util.List;
import com.socialnetwork.postModule.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}