package com.socialnetwork.postModule.PostModule.Services;

import java.util.List;

import com.socialnetwork.postModule.PostModule.Entities.Comment;
import com.socialnetwork.postModule.PostModule.Entities.CommentLikes;
import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Repositories.CommentLikesRepository;
import com.socialnetwork.postModule.PostModule.Repositories.CommentRepository;
import com.socialnetwork.postModule.PostModule.Repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentLikeService {

    private CommentLikesRepository likesRepository;
    private CommentRepository commentRepository;

    @Autowired
    public CommentLikeService(CommentLikesRepository likesRepository, CommentRepository commentRepository) {
        this.likesRepository = likesRepository;
        this.commentRepository = commentRepository;
    }

    public void likeComment(Integer userId, Integer commentId) throws Exception {
        List<Comment> comments = this.commentRepository.findById(commentId);

        if(comments.size()==0){
            throw new Exception("No comments with given id were found");
        }

        Comment comment = comments.get(0);

        this.likesRepository.save(new CommentLikes(userId, comment));
    }

    public void unlikeComment(Integer commentLikeId) throws Exception {
        List<CommentLikes> commentLikes = this.likesRepository.findById(commentLikeId);

        if(commentLikes.size()==0){
            throw new Exception("No comment like with given id was find");
        }

        CommentLikes like = commentLikes.get(0);

        this.likesRepository.delete(like);
    }
    
}