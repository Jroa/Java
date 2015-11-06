package test;

import org.junit.Test;

/**
 * JUnit TimeOut Test
 * @author Jonathan
 *
 */
public class JunitTest4 {

	@Test(timeout = 1000)
	public void infinity(){
		while(true);
	}
}
