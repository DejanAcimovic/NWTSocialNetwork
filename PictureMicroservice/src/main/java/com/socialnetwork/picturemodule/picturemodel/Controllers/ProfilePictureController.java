package com.socialnetwork.picturemodule.picturemodel.Controllers;

import org.springframework.web.bind.annotation.RestController;
import com.socialnetwork.picturemodule.picturemodel.Entities.*;
import com.socialnetwork.picturemodule.picturemodel.Services.ProfilePicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class ProfilePictureController {

    @Autowired
    private ProfilePicService service;

    /*    //vraćanje slike po imageid
    @RequestMapping(value="/picture/{imageId}", method=RequestMethod.GET)
    public @ResponseBody byte[] getImage(@RequestParam("imageId") Integer imageId)  throws IOException {
        return this.service.getPictureById(imageId);
    }

    //vraćanje idevaslike po postid
    @RequestMapping(value="/pictures/{postId}", method=RequestMethod.GET)
    public @ResponseBody
    List<Integer> getPicturesId(@RequestParam("postId") Integer postId)  throws IOException {
        return this.service.getPicturesIdByPostId(postId);
    }*/

    @RequestMapping(value="/picture/user/{userId}", method=RequestMethod.GET)
    public @ResponseBody byte[] getProfilePictureByUserId(@PathVariable("userId") Integer userId) {
        return service.getProfilePictureByUserId(userId);
    }

}