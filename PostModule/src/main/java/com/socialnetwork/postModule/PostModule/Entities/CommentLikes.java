package com.socialnetwork.postModule.PostModule.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
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

    public CommentLikes(Integer userId, Comment comment) throws Exception {
        
        if(userId < 0 || userId == null){
            throw new Exception("User id cannot be null or less than one");
        }
        this.userId = userId;

        if(comment == null){
            throw new Exception("Comment cannot be null");
        }
        this.comment = comment;
    }

    protected CommentLikes() {
    }

}