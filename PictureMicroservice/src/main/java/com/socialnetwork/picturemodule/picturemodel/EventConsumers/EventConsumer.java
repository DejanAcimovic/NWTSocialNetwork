package com.socialnetwork.picturemodule.picturemodel.EventConsumers;

import com.socialnetwork.picturemodule.picturemodel.Services.PictureService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * EventConsumer
 */
public class EventConsumer {


    @Autowired
    PictureService service;

    @RabbitListener(queues = "postDeletedQueues")
    public void deletePictures(String postid) throws Exception {

        Integer id = Integer.valueOf(postid);

        service.DeletePicturesWithPostId(id);
    }

    @RabbitListener(queues = "postServiceQueue")
    public void getMessage(String message){
        System.out.println(message);
    }
}