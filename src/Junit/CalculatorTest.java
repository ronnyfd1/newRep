package Junit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest extends TestBase {

	// no parameters in the test

	@Test
	public void sumOfNumbers_BiggerThan50_Integer() {
		assertFalse("The sum of numbers is less than 50", isAbove50(25, 26));

	}

	@Test
	public void sumOfNumbers_LessThan50_Integer() {
		assertTrue("The sum of numbers is bigger than 50", isAbove50(25, 21));

	}

	@Test
	public void sumOfNumbers_BiggerThan50_Double() {
		assertFalse("The sum of numbers is less than 50", isAbove50(25.5, 26.5));

	}

	@Test
	public void sumOfNumbers_LessThan50_Double() {
		assertTrue("The sum of numbers is bigger than 50", isAbove50(25.5, 21.5));

	}

}
