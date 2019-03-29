package com.socialnetwork.picturemodule.picturemodel.Services;

import java.util.ArrayList;
import java.util.List;
import com.socialnetwork.picturemodule.picturemodel.Entities.Picture;
import com.socialnetwork.picturemodule.picturemodel.Repositories.PictureRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PictureService {

    private PictureRepository pictureRepository;

    @Autowired
    public PictureService(PictureRepository _repository){
        this.pictureRepository = _repository;
    }

    //vraćanje slike po imageid
    public byte[] getPictureById(Integer imageId){
        Picture picture = pictureRepository.findPictureById(imageId);
        return picture.getPicture();
    }

    //vraćanje ideva slika po idu posta
    public List<Integer> getPicturesIdByPostId(Integer postId) {

        List<Integer> idevi = new ArrayList<Integer>(){};
        List<Picture> pictures = pictureRepository.findPicturesIdByPostId(postId);

        for (Picture pic:pictures) {
            idevi.add(pic.getId());
        }
        return idevi;

    }



    }

