package com.mascotin.petstore.management.models.clients;

import javax.persistence.*;
import javax.persistence.Entity;

import com.mascotin.petstore.catalogues.Breed;
import com.mascotin.petstore.catalogues.Specie;
import org.hibernate.annotations.*;
import org.openxava.annotations.*;

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