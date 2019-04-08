package com.socialnetwork.picturemodule.picturemodel.Controllers;

import com.socialnetwork.picturemodule.picturemodel.Contracts.PictureDTO;
import com.socialnetwork.picturemodule.picturemodel.Services.PictureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.socialnetwork.picturemodule.picturemodel.Entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;


@RestController
public class PictureController {

    @Autowired
    private PictureService service;


    //vraćanje slike po imageid
    @RequestMapping(value="/picture/{imageId}", method=RequestMethod.GET)
    public @ResponseBody String getImage(@RequestParam("imageId") Integer imageId) throws Exception {
        return this.service.getPictureById(imageId);
    }

    //vraćanje idevaslike po postid
    @RequestMapping(value="/pictures/{postId}", method=RequestMethod.GET)
    public @ResponseBody
    List<Integer> getPicturesId(@RequestParam("postId") Integer postId) throws Exception {
        try {
            return this.service.getPicturesIdByPostId(postId);
          //  return (List<Integer>) new ResponseEntity<String>(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    //post slika po postid
    @RequestMapping(value="/pictures/{postId}", method=RequestMethod.POST)
    public @ResponseBody Picture requestMethodName(@RequestBody PictureDTO picture) throws Exception {
        return service.SaveNewPicture(picture.toEntity());
   }



}