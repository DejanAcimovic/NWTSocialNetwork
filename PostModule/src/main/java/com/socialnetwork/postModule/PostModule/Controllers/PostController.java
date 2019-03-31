package com.socialnetwork.postModule.PostModule.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import com.socialnetwork.postModule.PostModule.Contracts.PostInsertDTO;
import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping(value="/posts/{userId}", method=RequestMethod.GET)
    public @ResponseBody List<Post> getPostByUserId(@PathVariable("userId") Integer userId) {
        
        try {
            return service.getPostByUserId(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @RequestMapping(value="/post", method=RequestMethod.POST)
    public @ResponseBody Post createNewPost(@RequestBody PostInsertDTO post) {
        try {
            return service.SaveNewPost(post.toEntity());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }   

    @RequestMapping(value="/post/postId", method=RequestMethod.DELETE)
    public ResponseEntity<String> deletePost(@RequestParam(name="postId") Integer postId) {
        try { 
            this.service.deletePost(postId);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
}