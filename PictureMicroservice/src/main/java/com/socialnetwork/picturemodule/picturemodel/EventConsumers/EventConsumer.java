package com.socialnetwork.picturemodule.picturemodel.EventConsumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * EventConsumer
 */
public class EventConsumer {

    
    @RabbitListener(queues = "postServiceQueue")
    public void getMessage(String message){
        System.out.println(message);
    }
}