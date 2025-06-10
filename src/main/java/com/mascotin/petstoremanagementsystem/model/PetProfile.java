package com.mascotin.petstoremanagementsystem.model;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.mascotin.petstoremanagementsystem.model.catalogue.*;

import lombok.*;

@Entity
@Getter @Setter
public class PetProfile {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String petId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ReferenceView("Simple")
    private User owner;

    @Column(length = 50)
    @Required
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @DescriptionsList
    private Specie specie;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    private Breed breed;

    private Integer age;

    @File
    private String photo;
}