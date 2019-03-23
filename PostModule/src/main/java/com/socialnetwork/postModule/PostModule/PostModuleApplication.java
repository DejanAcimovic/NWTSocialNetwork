package com.socialnetwork.postModule.PostModule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.socialnetwork.postModule.Repositories.PostRepository;
import com.socialnetwork.postModule.models.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication    
public class PostModuleApplication {

	private static final Logger log = LoggerFactory.getLogger(PostModuleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PostModuleApplication.class, args);

	}
	@Bean
	public CommandLineRunner demo(PostRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Post(3,1,"lskajdflkajf"));
			repository.save(new Post(4,2, "slkjdflaksjfdka"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Post post : repository.findAll()) {
				log.info(post.toString());
			}
			log.info("");
		};
	}

}
