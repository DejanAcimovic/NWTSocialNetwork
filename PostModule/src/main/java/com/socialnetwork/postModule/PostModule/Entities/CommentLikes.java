package com.socialnetwork.postModule.PostModule.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommentLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public Comment getComment() {
        return this.comment;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public CommentLikes(Integer userId, Comment comment) {
        this.userId = userId;
        this.comment = comment;
    }

    protected  CommentLikes() {}
    
}