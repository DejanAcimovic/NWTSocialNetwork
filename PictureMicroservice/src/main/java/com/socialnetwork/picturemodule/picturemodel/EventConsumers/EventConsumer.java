package com.socialnetwork.picturemodule.picturemodel.EventConsumers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialnetwork.picturemodule.picturemodel.Contracts.PicturesDTO;
import com.socialnetwork.picturemodule.picturemodel.Entities.Picture;
import com.socialnetwork.picturemodule.picturemodel.Services.PictureService;


import com.socialnetwork.picturemodule.picturemodel.Entities.ProfilePicture;
import com.socialnetwork.picturemodule.picturemodel.Services.ProfilePicService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * EventConsumer
 */
public class EventConsumer {

    @Autowired
    PictureService pictureService;


    @Autowired
    ProfilePicService profilePictureService;


    @RabbitListener(queues = "postDeletedQueues")
    public void deletePictures(String postid) throws Exception {

        Integer id = Integer.valueOf(postid);

        pictureService.DeletePicturesWithPostId(id);
    }


    @RabbitListener(queues = "postServiceQueue")
    public void getMessage(String urls) {
        System.out.println(urls);
        ObjectMapper mapper = new ObjectMapper();

        try {
            PicturesDTO pictures = mapper.readValue(urls, PicturesDTO.class);

            for (String url : pictures.urls) {
                try {
                    pictureService.SaveNewPicture(new Picture(url, pictures.id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "userServiceQueue")
    public void addProfilePicture(String messageUrl){

        String[] parts =messageUrl.split(",");
        String userID = parts[0];
        String url = parts[1];
        try {
            ProfilePicture pp = new ProfilePicture(url, Integer.valueOf(userID));
            profilePictureService.saveNewProfilePicture(pp);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        //System.out.println(message);
    }
}