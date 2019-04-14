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

    public String getProfilePictureByUserId(Integer userId) throws Exception {

        ProfilePicture profilePicture = profilePictureRepository.findProfilePictureByUserId(userId);

        if(profilePicture == null) {
            throw new Exception("No profile picture found with given user ID");
        }
        return profilePicture.getProfilePicture();

    }

    public ProfilePicture saveNewProfilePicture(ProfilePicture picture) throws Exception {

        if(picture == null)
        {
            throw new Exception("Picture not valid");
        }
        this.profilePictureRepository.save(picture);
        return  picture;
    }

    public void deleteProfilePicture(Integer userId) throws Exception {
        ProfilePicture profilePicture = this.profilePictureRepository.findProfilePictureByUserId(userId);

        if(profilePicture == null) {
            throw new Exception("No profile picture for this user ID");
        }
        this.profilePictureRepository.delete(profilePicture);

    }


}

