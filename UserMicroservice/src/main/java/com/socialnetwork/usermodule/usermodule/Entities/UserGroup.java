package com.socialnetwork.usermodule.usermodule.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String name;


    @ManyToMany(mappedBy = "groups")
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    protected UserGroup() {
    }

    public UserGroup(String _name, List<User> users) throws Exception {
        boolean valid = _name.matches("^[a-zA-Z\\s]*$");
        if(valid) {
            this.setName(_name);
            this.users = users;
        }
        else
            throw new Exception("Bad parameters");
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }
}