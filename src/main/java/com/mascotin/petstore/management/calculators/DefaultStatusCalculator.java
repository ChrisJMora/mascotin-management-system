package com.mascotin.petstore.management.calculators;

import org.openxava.calculators.*;

public class DefaultStatusCalculator implements ICalculator {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5548285905273088009L;

	public Object calculate() {
        return "PENDIENTE";
    }
}