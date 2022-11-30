package com.gestopago.springboot.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    // Default value is 'USER'
    @Column(nullable = false)
    private Role role = Role.USER;

}
