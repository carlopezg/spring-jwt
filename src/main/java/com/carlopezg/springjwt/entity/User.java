package com.carlopezg.springjwt.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "USER_NAME")
    String userName;

    @Column(name = "PASSWORD")
    String password;

}
