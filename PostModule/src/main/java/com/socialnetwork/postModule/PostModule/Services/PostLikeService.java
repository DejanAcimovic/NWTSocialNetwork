package com.socialnetwork.postModule.PostModule.Services;

import java.util.List;

import com.socialnetwork.postModule.PostModule.Entities.Comment;
import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Entities.PostLike;
import com.socialnetwork.postModule.PostModule.Repositories.CommentRepository;
import com.socialnetwork.postModule.PostModule.Repositories.LikeRepository;
import com.socialnetwork.postModule.PostModule.Repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostLikeService {

    private LikeRepository likeRepository;
    private PostRepository postRepository;

    @Autowired
    public PostLikeService(LikeRepository _repository, PostRepository postRepository){
        this.likeRepository = _repository;
        this.postRepository = postRepository;
    }

    public Post likePost(Integer userId, Integer postId) throws Exception {
        List<Post> posts = this.postRepository.findById(postId);

        if(posts.size() == 0){
            throw new Exception("Bad parameters");
        }

        Post post = posts.get(0);

        this.likeRepository.save(new PostLike(userId, post));

        return post;
    }
}
    
