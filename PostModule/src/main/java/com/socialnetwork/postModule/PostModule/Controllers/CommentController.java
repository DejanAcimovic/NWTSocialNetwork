package com.socialnetwork.postModule.PostModule.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import com.socialnetwork.postModule.PostModule.Contracts.CommentInsertDTO;
import com.socialnetwork.postModule.PostModule.Contracts.PostInsertDTO;
import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Services.CommentService;
import com.socialnetwork.postModule.PostModule.Services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CommentController {

    @Autowired
    private CommentService service;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Post requestMethodName(@RequestBody CommentInsertDTO param) {
        try {
            return this.service.addCommentToPost(param.postId, param.text, param.userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad parameters");
        }
    }
     
}