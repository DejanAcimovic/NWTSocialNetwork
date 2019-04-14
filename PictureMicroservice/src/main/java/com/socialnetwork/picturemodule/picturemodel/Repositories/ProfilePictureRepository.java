package com.socialnetwork.picturemodule.picturemodel.Repositories;
import java.util.List;

import com.socialnetwork.picturemodule.picturemodel.Entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilePictureRepository extends CrudRepository<ProfilePicture, Long> {

    ProfilePicture findProfilePictureByUserId(Integer userId);

}