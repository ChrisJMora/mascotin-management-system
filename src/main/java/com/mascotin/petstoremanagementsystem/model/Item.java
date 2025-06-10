package com.mascotin.petstoremanagementsystem.model;

import java.math.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Item {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String oid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ShoppingCart cart;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

    @Required
    private Integer quantity;
    
    @Transient
    @ReadOnly
    @Stereotype("MONEY")
    @Depends("product.price, quantity")
    public BigDecimal getSubtotal() {
        if (!isValidForSubtotal()) {
            return BigDecimal.ZERO;
        }
        return product.getPrice().multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.HALF_UP);
    }

    @Transient
    @ReadOnly
    @Stereotype("MONEY")
    @Depends("product.price, quantity, product.discount")
    public BigDecimal getDiscount() {
        BigDecimal subtotal = getSubtotal();
        if (!isValidForDiscount()) {
            return BigDecimal.ZERO;
        }
        return subtotal.multiply(product.getDiscount()).setScale(2, RoundingMode.HALF_UP);
    }

    @Transient
    @ReadOnly
    @Stereotype("MONEY")
    @Depends("product.price, quantity, product.discount")
    public BigDecimal getTotal() {
        return getSubtotal().subtract(getDiscount()).setScale(2, RoundingMode.HALF_UP);
    }

    private boolean isValidForSubtotal() {
        return product != null && product.getPrice() != null && quantity != null && quantity > 0;
    }

    private boolean isValidForDiscount() {
        return isValidForSubtotal() && product.getDiscount() != null 
               && product.getDiscount().compareTo(BigDecimal.ZERO) >= 0 
               && product.getDiscount().compareTo(BigDecimal.ONE) <= 0;
    }
}

