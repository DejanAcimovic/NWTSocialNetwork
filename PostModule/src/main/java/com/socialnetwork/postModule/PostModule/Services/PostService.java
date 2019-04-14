package com.socialnetwork.postModule.PostModule.Services;

import java.util.List;

import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;
import com.socialnetwork.postModule.PostModule.Entities.Post;
import com.socialnetwork.postModule.PostModule.Repositories.PostRepository;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import springfox.documentation.spring.web.json.Json;


@Service
public class PostService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Exchange exchange;

    private PostRepository repository;

    @Autowired
    public PostService(PostRepository _repository){
        this.repository = _repository;
    }

    public List<Post> getPostByUserId(Integer userId){
        return repository.findByUserId(userId);
    }

    public Post GetPostById(Integer id) throws Exception {
        List<Post> posts = this.repository.findById(id);

        if(posts.size() == 0){
            throw new Exception("No post with this id exists");
        }

        return posts.get(0);
    }

    public Post SaveNewPost(Post post) throws Exception {
        String uri = UriComponentsBuilder.fromUriString("http://user-module/get/user/user_id")
            .queryParam("userId", post.getUserId()).toUriString();
        try {
            //String response = this.restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            throw new Exception("Invalid user_id");
        }
        this.repository.save(post);

        String routingKey = "post.created";
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, "E kreirao se novi post" + post.getText());
        return post;
    }

    public void deletePost(Integer postId) throws Exception {
        List<Post> posts = this.repository.findById(postId);

        if(posts.size() == 0){
            throw new Exception("No post with this id exists");
        }

        Post post = posts.get(0);

        this.repository.delete(post);
    }
    
}