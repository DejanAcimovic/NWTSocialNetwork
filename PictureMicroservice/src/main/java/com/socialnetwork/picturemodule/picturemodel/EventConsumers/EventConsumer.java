package com.socialnetwork.picturemodule.picturemodel.EventConsumers;

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
    ProfilePicService service;

    @RabbitListener(queues = "postServiceQueue")
    public void getMessage(String message){
        System.out.println(message);
    }

    @RabbitListener(queues = "userServiceQueue")
    public void addProfilePicture(String messageUrl){

        String[] parts =messageUrl.split(",");
        String userID = parts[0];
        String url = parts[1];
        try {
            ProfilePicture pp = new ProfilePicture(url, Integer.valueOf(userID));
            service.saveNewProfilePicture(pp);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        //System.out.println(message);
    }
}