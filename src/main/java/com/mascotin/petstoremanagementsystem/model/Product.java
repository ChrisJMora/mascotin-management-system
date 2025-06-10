package com.mascotin.petstoremanagementsystem.model;

import java.math.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.mascotin.petstoremanagementsystem.model.catalogue.*;

import lombok.*;

@Entity
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String id;

    @Column(length = 100)
    @Required
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @DescriptionsList
    private Category category;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    private ProductType type;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    private Brand brand;

//    @Column(length = 50)
//    @DescriptionsList
//    private String manufacturer;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    private Container container;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @DescriptionsList
    private Specie specie;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    private Breed breed;
    
    @Column(length = 30)
    private String lifeStage;
    
    @Stereotype("MONEY")
    @Required
    private BigDecimal price;

    @Stereotype("MONEY")
    @Required
    private BigDecimal discount;

    @Required
    private Integer stock;

    @Stereotype("MEMO")
    private String description;
}