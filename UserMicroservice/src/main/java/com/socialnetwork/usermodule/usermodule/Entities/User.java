package com.socialnetwork.usermodule.usermodule.Entities;

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
    @JoinTable(name = "user_group_user",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_group_id", referencedColumnName = "id"))
    private List<UserGroup> groups = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tbl_friends",
            joinColumns = @JoinColumn(name = "personId"),
            inverseJoinColumns = @JoinColumn(name = "friendId")
    )
    private List<User> friends;

    @ManyToMany
    @JoinTable(name = "tbl_friends",
            joinColumns = @JoinColumn(name = "friendId"),
            inverseJoinColumns = @JoinColumn(name = "personId")
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


    public void addUserGroup(UserGroup group){
        this.getGroups().add(group);
    }

    public void addUserFriend(User friend){
        this.getFriends().add(friend);
    }

    protected User() {}


    public User(String _firstName, String _lastName) throws Exception {

        boolean valid = _firstName.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
        boolean validLast = _lastName.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
        //The first name is between 1 and 25 characters.
        //The first name can only start with an a-z (ignore case) character.
        //After that the first name can contain a-z (ignore case) and [ '-,.].
        //The first name can only end with an a-z (ignore case) character.

        if(valid==true && validLast==true) {
            this.firstName = _firstName;
            this.lastName = _lastName;
            this.groups = new ArrayList<UserGroup>();
        }

        else
            throw new Exception("Parameters invalid");
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<UserGroup> getGroups() {
        return groups;
    }


}