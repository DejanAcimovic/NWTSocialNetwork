package com.socialnetwork.pictureModule.PictureModule.Repositories;

import com.socialnetwork.pictureModule.PictureModule.Entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {
}