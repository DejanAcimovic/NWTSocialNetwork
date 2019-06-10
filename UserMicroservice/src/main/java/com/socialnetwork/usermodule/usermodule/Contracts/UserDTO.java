package com.socialnetwork.usermodule.usermodule.Contracts;

import com.socialnetwork.usermodule.usermodule.Entities.User;

public class UserDTO {

    public String firstName;
    public String lastName;
    public String email;
    public String username;
    public String password;
    public String url;

    public UserDTO (String _firstName, String _lastName, String _email, String _password, String _username ){
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.password = _password;
        this.username = _username;
    }

    private UserDTO (){}

    public User toEntity () throws Exception{

        return new User(this.firstName, this.lastName, this.email, this.password, this.username);

    }
}