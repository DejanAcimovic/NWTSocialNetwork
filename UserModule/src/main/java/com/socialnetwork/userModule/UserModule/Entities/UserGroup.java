package com.socialnetwork.userModule.UserModule.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    protected UserGroup() {}

    public User(String _name, User user) {
        this.name = _name;
        this.user = user;
    }
}