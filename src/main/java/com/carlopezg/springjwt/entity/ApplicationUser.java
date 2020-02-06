package com.carlopezg.springjwt.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "S_APPLICATION_USER")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

}
