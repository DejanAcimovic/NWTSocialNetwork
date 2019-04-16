package com.socialnetwork.postModule.PostModule.Contracts;

import java.util.List;

import com.socialnetwork.postModule.PostModule.Entities.Post;

public class PostInsertDTO {
    public String text;
    public Integer userId;
    public List<String> urls;  

    public PostInsertDTO(){}

    public Post toEntity() throws Exception {
        return new Post(this.userId, this.text);
    }
}