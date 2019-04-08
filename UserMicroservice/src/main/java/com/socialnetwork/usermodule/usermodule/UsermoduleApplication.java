package com.socialnetwork.usermodule.usermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsermoduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermoduleApplication.class, args);
    }

}
