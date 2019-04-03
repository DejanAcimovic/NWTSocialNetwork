package com.socialnetwork.picturemodule.picturemodel.Services;

import com.socialnetwork.picturemodule.picturemodel.Entities.Picture;
import com.socialnetwork.picturemodule.picturemodel.Entities.ProfilePicture;
import com.socialnetwork.picturemodule.picturemodel.Repositories.ProfilePictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfilePicService {

    private ProfilePictureRepository profilePictureRepository;

    @Autowired
    public ProfilePicService(ProfilePictureRepository _repository){
        this.profilePictureRepository = _repository;
    }

    public String getProfilePictureByUserId(Integer userId){

        ProfilePicture profilePicture = profilePictureRepository.findProfilePictureByUserId(userId);
        return profilePicture.getProfilePicture();

    }

    public ProfilePicture saveNewProfilePicture(ProfilePicture picture) {
        this.profilePictureRepository.save(picture);
        return  picture;
    }

}

