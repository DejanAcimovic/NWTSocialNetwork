package com.socialnetwork.postModule.PostModule.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private Integer userId;
    @Column
    private String text;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<PostLike> likes = new ArrayList<>();

    public List<PostLike> getLikes() {
        return this.likes;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getUserId() {
        return userId;
    }

    protected Post() {
    }

    public Post(Integer _userId, String _text) throws Exception {

        if(_userId < 0 || _userId == null){
            throw new Exception("User id cannot be null or less than one");
        }
        this.userId = _userId;

        if(_text.replaceAll("\\s+","").equals(new String(""))){
            throw new Exception("Post text must not be null");
        }
        this.text = _text;
    }
}