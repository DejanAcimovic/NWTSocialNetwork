package com.socialnetwork.postModule.PostModule.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.socialnetwork.postModule.PostModule.Contracts.PostLikeDTO;
import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Services.PostLikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class PostLikeController {

    @Autowired
    private PostLikeService service;

    @RequestMapping(value = "/post/like", method = RequestMethod.POST)
    public Post addLikeOnPost(@RequestBody PostLikeDTO param) {
        try {
            return service.likePost(param.userId, param.postId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad parameters");
        }
    }
    
 
}