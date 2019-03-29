package com.socialnetwork.postModule.PostModule.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.socialnetwork.postModule.PostModule.Contracts.PostLikeDTO;
import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Services.PostLikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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

    @RequestMapping(value="/post/like/{likeId}", method=RequestMethod.DELETE)
    public ResponseEntity<String> unlikePost(@RequestParam(name="likeId") Integer likeId) {
        try {
            this.service.unlikePost(likeId);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad parameters");
        }
    }
    
    
 
}