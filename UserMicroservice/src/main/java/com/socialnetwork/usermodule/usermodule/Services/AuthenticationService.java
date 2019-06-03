package com.socialnetwork.usermodule.usermodule.Services;

import javax.persistence.EntityNotFoundException;

import com.socialnetwork.usermodule.usermodule.Repositories.UserRepository;

import com.socialnetwork.usermodule.usermodule.Entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AuthenticationService
 */
@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenService jwtTokenService;

    public AuthenticationService() {
    }

    public String generateJWTToken(String username, String password) {
        User user = userRepository.findOneByUsername(username);

        if(user != null && password.equals(user.getPassword())){
            return jwtTokenService.generateToken(username);
        }else{
            throw new EntityNotFoundException("Account not found");
        }
    }
    
}