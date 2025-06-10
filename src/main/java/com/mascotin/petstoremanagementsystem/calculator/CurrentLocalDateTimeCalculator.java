package com.mascotin.petstoremanagementsystem.calculator;

import java.time.*;

import org.openxava.calculators.*;

public class CurrentLocalDateTimeCalculator implements ICalculator {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7071279301492466419L;

	public Object calculate() throws Exception {
        return LocalDateTime.now();
    }
}