package com.socialnetwork.picturemodule.picturemodel.Repositories;
import java.util.ArrayList;
import java.util.List;

import com.socialnetwork.picturemodule.picturemodel.Entities.*;
import io.swagger.models.auth.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {

    //vraćanje slike po imageid
    Picture findPictureById(Integer imageId);

    //vraćanje ideva slika po id posta
    List<Picture> findPicturesIdByPostId(Integer postId);


}