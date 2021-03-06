package com.socialnetwork.postModule.PostModule.Services;

import java.util.List;

import com.socialnetwork.postModule.PostModule.Entities.Comment;
import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Repositories.CommentRepository;
import com.socialnetwork.postModule.PostModule.Repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService {

    private PostRepository repository;
    private CommentRepository commentRepository;

    @Autowired
    public CommentService(PostRepository _repository, CommentRepository commentRepository) {
        this.repository = _repository;
        this.commentRepository = commentRepository;
    }

    public Post addCommentToPost(Integer postId, String commentText, Integer userId) throws Exception {
        List<Post> posts = this.repository.findById(postId);

        if(posts.size() == 0){
            throw new Exception("Post with this id does not exist");
        }

        Post post = posts.get(0);

        this.commentRepository.save(new Comment(commentText, post, userId));

        return post;
    }

    public void deleteComment(Integer commentId) throws Exception {
        List<Comment> comments = this.commentRepository.findById(commentId);

        if(comments.size() == 0){
            throw new Exception("Comment with this id does not exist");
        }

        Comment comment = comments.get(0);

        this.commentRepository.delete(comment);
    }
    
}