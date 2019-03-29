
package com.socialnetwork.picturemodule.picturemodel.Entities;

import io.swagger.models.auth.In;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer userId;
    @Lob
    @Column
    private byte[] profilePicture;

    protected  ProfilePicture() {}

    public ProfilePicture(byte[] picture, Integer userId){

        this.profilePicture = picture;
        this.userId = userId;
    }

    public byte[] getPicture() {
        return profilePicture;
    }
}