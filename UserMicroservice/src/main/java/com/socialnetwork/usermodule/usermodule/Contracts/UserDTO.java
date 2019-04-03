package com.socialnetwork.usermodule.usermodule.Contracts;

import com.socialnetwork.usermodule.usermodule.Entities.User;

public class UserDTO {

    private String firstName;
    private String lastName;

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
    public UserDTO (String _firstName, String _lastName){
        this.firstName = _firstName;
        this.lastName = _lastName;
    }

    private UserDTO (){}

    public User toEntity () throws Exception{

            return new User(this.firstName, this.lastName);

    }
}
