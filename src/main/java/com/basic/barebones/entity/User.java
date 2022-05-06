package com.basic.barebones.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    private String userName;
    private String userPassword;
    private String firstName;
    private String lastName;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns =
            @JoinColumn(name = "user_id")
            ,
            inverseJoinColumns =
            @JoinColumn(name = "role_id")

    )
    private Set<Role> roles;

    public User(String userName, String userPassword, String firstName, String lastName, Set<Role> roles) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }
}
