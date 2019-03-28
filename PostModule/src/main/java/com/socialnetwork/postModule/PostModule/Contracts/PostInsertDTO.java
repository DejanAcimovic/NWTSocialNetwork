package com.socialnetwork.postModule.PostModule.Contracts;

import com.socialnetwork.postModule.PostModule.Entities.Post;

public class PostInsertDTO {
    public String text;
    public Integer userId; 

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public PostInsertDTO(String text, Integer userId) {
        this.text = text;
        this.userId = userId;
    }

    public PostInsertDTO(){}

    public Post toEntity(){
        return new Post(this.userId, this.text);
    }
}