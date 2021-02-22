package com.ppenchev.notes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Column(name = "user_id")
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private UserRole role;

    public User(String name, String password, UserRole role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
