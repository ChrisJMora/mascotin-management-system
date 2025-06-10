package com.mascotin.petstore.management.models.purchase;

import java.math.*;
import java.time.*;

import javax.persistence.*;

import com.mascotin.petstore.management.calculators.CurrentLocalDateTimeCalculator;
import com.mascotin.petstore.management.interfaces.Identifiable;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(members = "date, total;")
public abstract class CommercialDocument extends Identifiable {
    @Required
    @DefaultValueCalculator(CurrentLocalDateTimeCalculator.class)
    private LocalDateTime date;

    @Money
    @ReadOnly
    private BigDecimal total;

    private void calculateTotal() {
        ShoppingCart cart = getCart();
        if (cart != null && cart.getItems() != null) {
            total = cart.getItems().stream()
                .map(Item::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        } else {
            total = BigDecimal.ZERO;
        }
    }

    protected abstract ShoppingCart getCart();
}