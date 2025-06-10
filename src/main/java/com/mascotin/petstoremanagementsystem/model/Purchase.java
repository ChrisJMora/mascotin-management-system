package com.mascotin.petstoremanagementsystem.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Purchase extends CommercialDocument {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private ShoppingCart cart;

    @Stereotype("MEMO")
    private String paymentDetails;

    @Override
    protected ShoppingCart getCart() {
        return cart;
    }
}