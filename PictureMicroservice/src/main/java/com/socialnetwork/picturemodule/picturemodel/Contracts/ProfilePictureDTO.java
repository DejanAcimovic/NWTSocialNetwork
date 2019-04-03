package com.socialnetwork.picturemodule.picturemodel.Contracts;
import com.socialnetwork.picturemodule.picturemodel.Entities.*;
import io.swagger.models.auth.In;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;


public class ProfilePictureDTO {

    private String url;
    private Integer userId;


    public ProfilePictureDTO() {}
    public ProfilePictureDTO(String url, Integer userId){
        this.url = url;
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPostId() {
        return userId;
    }

    public void setPostId(Integer postId) {
        this.userId = postId;
    }

    public ProfilePicture toEntity() {

        return new ProfilePicture(this.url,this.userId);
    }
}
