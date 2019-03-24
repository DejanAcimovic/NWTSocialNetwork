package com.socialnetwork.pictureModule.PictureModule.Entities;

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

    @Lob
    @Column
    private byte[] picture;

    protected  Picture() {}

    public Picture(byte[] picture){
        this.picture = picture; 
    }
  
}