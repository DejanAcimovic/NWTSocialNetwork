package com.socialnetwork.postModule.PostModule.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Integer getId() {
        return this.id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public PostLike(Integer userId, Post post) throws Exception {
        if(userId < 0 || userId == null){
            throw new Exception("User id cannot be null or less than one");
        }
        this.userId = userId;

        if(post == null){
            throw new Exception("Post cannot be null");
        }
        this.post = post;
    }

    protected PostLike() {}

}