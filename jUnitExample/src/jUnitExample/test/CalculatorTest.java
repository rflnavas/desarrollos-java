package jUnitExample.test;

import static org.junit.Assert.assertTrue;


import jUnitExample.myservices.Calculator;

import org.junit.Test;

public class CalculatorTest {

	@Test(expected = (NumberFormatException.class))
	public final void cuandoAlgunaLetraEnCadenaEntoncesExcepcion(){
		Calculator.add("1,r,5");
		//System.out.println(suma);
	}
	
	@Test
	public final void cuandoCadenaVaciaEntoncesDevolverCero(){
		int suma = Calculator.add("");
		assertTrue(suma == 0);
	}
	
	@Test
	public final void sumaNumerosCoincideConOperacion(){
		int suma = Calculator.add("1,2,3,4");
		assertTrue(1 + 2 + 3+ 4 == suma);
	}
	
	@Test
	public final void suma(){
		int resultado = Calculator.add(2,3);
		//Sin import static
		//Assert.assertTrue(resultado == 5);
		assertTrue(resultado == 7);
	}
	
	 @Test(expected = ArithmeticException.class)
	public final void dividePorCero(){
		Calculator.divide(3, 0);
	}

}
