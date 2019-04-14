
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

    public Picture(String picture, Integer postId) throws Exception {

        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        if(picture.matches(regex)) {

            this.picture = picture;
        }
        else {
            throw new Exception("URL is not valid");
        }

        this.postId = postId;
        //this.picture = picture;
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

    public void setPicture(String picture) throws Exception {

        String regex = "<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>";

        if(picture.matches(regex)) {

            this.picture = picture;
        }
        else {
            throw new Exception("URL is not valid");
        }


        this.picture = picture;
    }
}