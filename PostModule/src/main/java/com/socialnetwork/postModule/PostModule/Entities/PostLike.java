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

    public PostLike(Integer userId, Post post) {
        this.userId = userId;
        this.post = post;
    }

    protected PostLike() {
    }

}