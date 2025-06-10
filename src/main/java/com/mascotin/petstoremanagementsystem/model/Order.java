package com.mascotin.petstoremanagementsystem.model;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@View(extendsView = "super.DEFAULT", members = "purchase; deliveryDate, deliveryMethod, status; observations;")
@Getter @Setter
public class Order extends CommercialDocument {
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Purchase purchase;

    private LocalDateTime deliveryDate;

    @Column(length = 50)
    @Required
    private String deliveryMethod;

    @Stereotype("MEMO")
    private String observations;

    @Column(length = 20)
    @Required
    @DefaultValueCalculator(com.mascotin.petstoremanagementsystem.calculator.DefaultStatusCalculator.class)
    private String status;

    @Override
    protected ShoppingCart getCart() {
        return purchase != null ? purchase.getCart() : null;
    }
}