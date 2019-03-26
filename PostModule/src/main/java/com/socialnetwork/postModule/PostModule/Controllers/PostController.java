package com.socialnetwork.postModule.PostModule.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.postModule.PostModule.Entities.Post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class PostController {

    @RequestMapping(value="/posts", method=RequestMethod.GET)
    public Post getPost() {
        return new Post(1, "laksjdflkajfsd");
    }
    
}