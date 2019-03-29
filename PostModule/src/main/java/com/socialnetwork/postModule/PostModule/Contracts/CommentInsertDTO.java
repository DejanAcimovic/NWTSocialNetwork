package com.socialnetwork.postModule.PostModule.Contracts;


public class CommentInsertDTO {

    public Integer postId; 
    public Integer userId;
    public String text; 

    public CommentInsertDTO(Integer postId, Integer userId, String text) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
    }

    public CommentInsertDTO() {}
}