package com.mascotin.petstoremanagementsystem.model;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@View(name="Simple", members="username, email;")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String id;

    @Column(length = 50, unique = true)
    @Required
    private String username;

    @Column(length = 100, unique = true)
    @Required
    @Stereotype("EMAIL")
    private String email;

    @Column(length = 100)
    @Required
    @Stereotype("PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @Required
    private Role role;

    @Column(length = 10)
    private String employeeCode;
}

enum Role {
    CLIENTE, EMPLEADO, ADMINISTRADOR
}