package com.socialnetwork.postModule.PostModule.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.socialnetwork.postModule.PostModule.Contracts.PostInsertDTO;
import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping(value="/posts/{userId}", method=RequestMethod.GET)
    public @ResponseBody List<Post> getPostByUserId(@PathVariable("userId") Integer userId) {
        return service.getPostByUserId(userId);
    }

    @RequestMapping(value="/post", method=RequestMethod.POST)
    public @ResponseBody Post requestMethodName(@RequestBody PostInsertDTO post) {
        return service.SaveNewPost(post.toEntity());
    }   
}