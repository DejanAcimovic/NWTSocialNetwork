package com.socialnetwork.postModule.PostModule.Services;

import java.util.List;

import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    private PostRepository repository;

    @Autowired
    public PostService(PostRepository _repository){
        this.repository = _repository;
    }

    public List<Post> getPostByUserId(Integer userId){
        return repository.findByUserId(userId);
    }

    public Post SaveNewPost(Post post){
        this.repository.save(post);
        return post;
    }

    public void deletePost(Integer postId) throws Exception {
        List<Post> posts = this.repository.findById(postId);

        if(posts.size() == 0){
            throw new Exception("No post with this id exists");
        }

        Post post = posts.get(0);

        this.repository.delete(post);
    }
    
}