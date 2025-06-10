package com.mascotin.petstoremanagementsystem.model.catalogue;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Category {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String id;

    @Column(length = 50)
    @Required
    private String name;

}

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    private Collection<Product> products;