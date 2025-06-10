package com.mascotin.petstoremanagementsystem.model;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class ShoppingCart extends Identificable {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @OneToMany(mappedBy="cart", cascade=CascadeType.ALL, orphanRemoval=true)
    private Collection<Item> items;

    @Stereotype("MONEY")
    private BigDecimal total;

    @SuppressWarnings("unused")
	private void calculateTotal() {
        if (items != null) {
            total = items.stream()
                .map(Item::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }
}

//@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)