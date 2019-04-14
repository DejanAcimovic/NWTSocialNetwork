package com.socialnetwork.picturemodule.picturemodel.EventConsumers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialnetwork.picturemodule.picturemodel.Contracts.PicturesDTO;
import com.socialnetwork.picturemodule.picturemodel.Entities.Picture;
import com.socialnetwork.picturemodule.picturemodel.Services.PictureService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * EventConsumer
 */
public class EventConsumer {

    @Autowired
    PictureService service;

    @RabbitListener(queues = "postServiceQueue")
    public void getMessage(String urls) {
        System.out.println(urls);
        ObjectMapper mapper = new ObjectMapper();

        try {
            PicturesDTO pictures = mapper.readValue(urls, PicturesDTO.class);

            for (String url : pictures.urls) {
                try {
                    service.SaveNewPicture(new Picture(url, pictures.id));
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
}