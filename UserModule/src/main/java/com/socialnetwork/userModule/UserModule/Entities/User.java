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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

//  Malo me zbunjuju ove veze pa ne znam kako ovdje staviti. Iz one UserGroupUser tabele bi trebalo valjda biti ovdje
    // ManyToOne ili ne?
    public Integer getId() {
    return id;
}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    protected User() {}

    public User(String _firstName,String _lastName) {
        this.firstName = _firstName;
        this.lastName = _lastName;
    }


}