package com.socialnetwork.picturemodule.picturemodel.Contracts;

import java.io.Serializable;
import java.util.List;

/**
 * PictureDTO
 */
public class PicturesDTO implements Serializable{

    public Integer id;
    public  List<String> urls;

    public PicturesDTO(){}
}