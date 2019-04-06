package com.socialnetwork.picturemodule.picturemodel.Contracts;

import com.socialnetwork.picturemodule.picturemodel.Entities.Picture;

public class PictureDTO {

    private String url;
    private Integer postId;


    public PictureDTO() {}
    public PictureDTO(String url, Integer postId){
        this.url = url;
        this.postId = postId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Picture toEntity() throws Exception {

        return new Picture(this.url,this.postId);
    }
}
