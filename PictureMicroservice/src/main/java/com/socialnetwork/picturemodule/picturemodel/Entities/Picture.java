
package com.socialnetwork.picturemodule.picturemodel.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer postId;


    @Column (nullable = false)
    private String picture;

    protected  Picture() {}

    public Picture(String picture, Integer postId){
        this.picture = picture;
        this.postId = postId;
    }

    public String getPicture() {
        return picture;
    }

    public Integer getPostId(){
        return postId;
    }

    public Integer getId() {
        return id;
    }


}