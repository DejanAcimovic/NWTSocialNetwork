package com.socialnetwork.picturemodule.picturemodel.Services;

import java.util.ArrayList;
import java.util.List;
import com.socialnetwork.picturemodule.picturemodel.Entities.Picture;
import com.socialnetwork.picturemodule.picturemodel.Repositories.PictureRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class PictureService {

    @Autowired
    RestTemplate restTemplate;

    private PictureRepository pictureRepository;

    @Autowired
    public PictureService(PictureRepository _repository){
        this.pictureRepository = _repository;
    }

    //vraćanje slike po imageid
    public String getPictureById(Integer imageId) throws Exception {
        Picture picture = pictureRepository.findPictureById(imageId);

        if(picture == null) {
            throw new Exception("No picture found with given ID");
        }
        return picture.getPicture();
    }

    //vraćanje ideva slika po idu posta
    public List<Integer> getPicturesIdByPostId(Integer postId) throws Exception {

        List<Integer> idevi = new ArrayList<Integer>(){};
        List<Picture> pictures = pictureRepository.findPicturesIdByPostId(postId);

        if(pictures.size() == 0) {
            throw new Exception("No pictures found with given postID");
        }
        for (Picture pic:pictures) {
            idevi.add(pic.getId());
        }
        return idevi;
    }


    public Picture SaveNewPicture(Picture picture) throws Exception {
        try {
            String response = restTemplate.getForObject("http://postModule/posts/"+picture.getPostId(), String.class);
        } catch (Exception e) {
            throw new Exception("Invalid post_id");
        }
        if(picture == null) {
            throw new Exception("Picture is not valid");
        }
        this.pictureRepository.save(picture);
        return  picture;
        }
    }


