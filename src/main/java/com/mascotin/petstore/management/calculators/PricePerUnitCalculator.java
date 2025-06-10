package com.mascotin.petstore.management.calculators;

import static org.openxava.jpa.XPersistence.getManager;

import java.math.*;

import com.mascotin.petstore.management.models.inventory.Product;
import org.openxava.calculators.*;

import lombok.*;

public class PricePerUnitCalculator implements ICalculator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4092383168676080513L;

	@Getter @Setter
	private String productId;
	
	@Override
	public Object calculate() throws Exception {
		Product product = getProductById(productId);
		if (product == null) {		
			return BigDecimal.ZERO;
		}
		return product.getPrice();
	}
	
	
	private Product getProductById(String id) {
		return getManager().find(Product.class, id);
	}
}
