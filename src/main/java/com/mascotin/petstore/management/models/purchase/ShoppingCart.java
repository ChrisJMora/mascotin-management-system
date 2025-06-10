package com.mascotin.petstore.management.models.purchase;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import com.mascotin.petstore.management.interfaces.Identifiable;
import com.mascotin.petstore.management.models.clients.User;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class ShoppingCart extends Identifiable {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @OneToMany(mappedBy="cart", cascade=CascadeType.ALL, orphanRemoval=true)
    @ListProperties("product.name, quantity, product.discount, subtotal, discount, total")
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