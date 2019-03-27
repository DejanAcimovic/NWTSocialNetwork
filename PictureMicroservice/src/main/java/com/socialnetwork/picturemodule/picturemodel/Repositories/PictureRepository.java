package com.socialnetwork.picturemodule.picturemodel.Repositories;

import com.socialnetwork.picturemodule.picturemodel.Entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {
}