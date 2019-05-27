package com.socialnetwork.usermodule.usermodule.Contracts;

import com.socialnetwork.usermodule.usermodule.Entities.User;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;


    public String url;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
