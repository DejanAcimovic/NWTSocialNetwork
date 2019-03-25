package com.socialnetwork.userModule.UserModule.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name = "user_gorup_user",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_group_id", referencedColumnName = "id"))
    private List<UserGroup> groups = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="tbl_friends",
    joinColumns=@JoinColumn(name="personId"),
    inverseJoinColumns=@JoinColumn(name="friendId")
    )
    private List<User> friends;

    @ManyToMany
    @JoinTable(name="tbl_friends",
    joinColumns=@JoinColumn(name="friendId"),
    inverseJoinColumns=@JoinColumn(name="personId")
    )
    private List<User> friendOf;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addUserGorup(UserGroup group){
        this.groups.add(group);
    }

    protected User() {}

    public User(String _firstName,String _lastName) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.groups = new ArrayList<UserGroup>();
    }
}