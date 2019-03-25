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
public class UserGroupUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)

    @OneToMany
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "userGroup_id")
    private UserGroup userGroup;

    protected UserGroupUser() {}

    public UserGroupUser(User user, UserGroup userGroup) {
        this.user = user;
        this.userGroup = userGroup;
    }
}