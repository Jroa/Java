/**
 * 
 */
package test;

import org.junit.Test;

/**
 * JUnit Expected Exception Test
 * @author Jonathan
 *
 */
public class JunitTest2 {

	@Test(expected = ArithmeticException.class)
	public void divisionWithException(){
		int i = 1/0;
	}
	
}
