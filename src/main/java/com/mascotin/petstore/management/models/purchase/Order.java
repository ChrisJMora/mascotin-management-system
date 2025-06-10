package com.mascotin.petstore.management.models.purchase;

import java.time.*;

import javax.persistence.*;

import com.mascotin.petstore.management.calculators.DefaultStatusCalculator;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@View(extendsView = "super.DEFAULT", members = "purchase; deliveryDate, deliveryMethod, status; observations;")
@Getter @Setter
public class Order extends CommercialDocument {
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Invoice purchase;

    private LocalDateTime deliveryDate;

    @Column(length = 50)
    @Required
    private String deliveryMethod;

    @Stereotype("MEMO")
    private String observations;

    @Column(length = 20)
    @Required
    @DefaultValueCalculator(DefaultStatusCalculator.class)
    private String status;

    @Override
    protected ShoppingCart getCart() {
        return purchase != null ? purchase.getCart() : null;
    }
}