package com.socialnetwork.postModule.PostModule.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String text;

    @Column 
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;

    @OneToMany(mappedBy = "comment", orphanRemoval = true)
    private List<CommentLikes> likes;

    public Integer getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public List<CommentLikes> getLikes() {
        return this.likes;
    }

    protected Comment() {
    }

    public Comment(String text, Post post, Integer userId) throws Exception {
        if(text.replaceAll("\\s+","").equals(new String(""))){
            throw new Exception("Comment text must not be empty");
        }
        this.text = text;

        if(post == null){
            throw new Exception("Post cannot be null");
        }
        this.post = post;

        if(userId < 0 || userId == null){
            throw new Exception("User id cannot be null or less than one");
        }
        this.userId = userId;
    }
}