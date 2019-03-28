package com.socialnetwork.postModule.PostModule.Contracts;

import com.socialnetwork.postModule.PostModule.Entities.Comment;

public class CommentInsertDTO {

    public Integer postId; 
    public Integer userId;
    public String text; 
    

    public Integer getPostId() {
        return this.postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CommentInsertDTO(Integer postId, Integer userId, String text) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
    }

    public CommentInsertDTO() {}
}