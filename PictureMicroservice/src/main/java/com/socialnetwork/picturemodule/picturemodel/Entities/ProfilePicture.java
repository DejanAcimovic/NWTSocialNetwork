
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

    @Column (nullable = false)
    private String profilePicture;

    protected  ProfilePicture() {}

    public ProfilePicture(String picture, Integer userId) throws Exception {

        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        if(picture.matches(regex)) {

            this.profilePicture = picture;
        }
        else {
            throw new Exception("URL is not valid");
        }

       // this.profilePicture = picture;
        this.userId = userId;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) throws Exception {

        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        if(profilePicture.matches(regex)) {

            this.profilePicture = profilePicture;
        }
        else {
            throw new Exception("URL is not valid");
        }

    }
}