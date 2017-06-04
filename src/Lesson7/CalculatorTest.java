package Lesson7;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	
	BasicTest basicTest = new BasicTest();


	@Test
	public void test() {
		assertFalse("if grater than 50 result should be false" , basicTest.sum(30, 49));
	
	}
	
	@Test
	public void test1() {
		assertTrue("if less than 50 result should be true", basicTest.sum(99, 12));
	
	}
	
	@Test 
	public void test2() {
	//	assertThat("").isEmpty();
		
		Assert.assertEquals(basicTest.sum(11, 12), false);
	}


}
