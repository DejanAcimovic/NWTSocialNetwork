package com.socialnetwork.postModule.PostModule.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.socialnetwork.postModule.PostModule.Contracts.CommentLikeInsertDTO;
import com.socialnetwork.postModule.PostModule.Services.CommentLikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CommentLikeController {

    @Autowired
    private CommentLikeService service;

    @RequestMapping(value="/comment/like", method=RequestMethod.POST)
    public ResponseEntity<String> likeComment(@RequestBody CommentLikeInsertDTO commentLike) {
        try {
            this.service.likeComment(commentLike.userId, commentLike.commentId);

            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @RequestMapping(value="/comment/like/{likeId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> unlikeComment(@RequestParam(name="likeId") Integer likeId){
        try {
            this.service.unlikeComment(likeId);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}