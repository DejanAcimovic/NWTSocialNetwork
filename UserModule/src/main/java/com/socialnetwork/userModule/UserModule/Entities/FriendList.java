package com.socialnetwork.userModule.UserModule.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class FriendList {


    @OneToMany
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "user_id")
    private User user;


    protected FriendList() {}

    public FriendList(User user1, User user2) {
        this.user = user1;
        this.user = user2;
    }


}