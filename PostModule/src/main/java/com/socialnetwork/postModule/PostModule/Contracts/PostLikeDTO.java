package com.socialnetwork.postModule.PostModule.Contracts;

public class PostLikeDTO {

    public Integer postId;
    public Integer userId;

    public PostLikeDTO() {}


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

}