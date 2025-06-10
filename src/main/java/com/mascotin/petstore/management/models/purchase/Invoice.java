package com.mascotin.petstore.management.models.purchase;

import javax.persistence.*;

import com.mascotin.petstore.management.models.clients.User;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Invoice extends CommercialDocument {
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