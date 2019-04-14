package com.socialnetwork.postModule.PostModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PostModuleApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(PostModuleApplication.class, args);
    }
    
}
