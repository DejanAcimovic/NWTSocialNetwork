package com.socialnetwork.postModule.PostModule.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.socialnetwork.postModule.PostModule.Contracts.CommentInsertDTO;
import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CommentController {

    @Autowired
    private CommentService service;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Post addNewComment(@RequestBody CommentInsertDTO param) {
        try {
            return this.service.addCommentToPost(param.postId, param.text, param.userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @RequestMapping(value="/comment/{commentId}", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteComment(@RequestParam(name="commentId") Integer commentId) {
        try {
            this.service.deleteComment(commentId);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
     
}