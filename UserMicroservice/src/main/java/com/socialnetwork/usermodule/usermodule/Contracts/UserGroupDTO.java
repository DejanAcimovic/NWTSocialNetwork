package com.socialnetwork.usermodule.usermodule.Contracts;

import com.socialnetwork.usermodule.usermodule.Entities.UserGroup;

public class UserGroupDTO {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private UserGroupDTO() {}

    public UserGroupDTO (String _name){
        this.name = _name;
    }

    public UserGroup toEntity () throws Exception{
        return new UserGroup(this.name,null);
    }

}
