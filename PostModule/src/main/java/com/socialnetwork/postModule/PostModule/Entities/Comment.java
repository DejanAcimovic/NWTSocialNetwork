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


@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment")
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

    protected Comment() {}

    public Comment(String _text, Post post) {
        this.text = _text;
        this.post = post; 
    }
}