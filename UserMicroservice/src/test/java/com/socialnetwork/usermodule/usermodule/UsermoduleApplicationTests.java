package com.socialnetwork.usermodule.usermodule;

import java.net.URI;
import java.net.URISyntaxException;

import com.google.common.net.HttpHeaders;
import com.socialnetwork.usermodule.usermodule.Contracts.UserDTO;
import com.socialnetwork.usermodule.usermodule.Controllers.UserController;
import com.socialnetwork.usermodule.usermodule.Entities.User;
import com.socialnetwork.usermodule.usermodule.Repositories.UserRepository;
import com.socialnetwork.usermodule.usermodule.Services.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermoduleApplicationTests {

    @Autowired
    UserRepository repository;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Exchange exchange; 

    @Test
    public void userCreated() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
     

        User user = new User("test", "test");
        String url = "http://tineye.com/images/widgets/mona.jpg";

        UserService service = new UserService(repository, exchange, rabbitTemplate);
        User str = service.saveNewUser(user, url);


        final String baseUrl = "http://localhost:4321/picture/user/" + str.getId();

        URI uri = new URI(baseUrl);

        String response = restTemplate.getForObject(baseUrl, String.class);
        
        Assert.assertNotNull(response);
        
    }

}
