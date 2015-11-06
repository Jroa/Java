package test;

import org.junit.Ignore;
import org.junit.Test;


/**
 * JUnit Ignore Test
 * @author Jonathan
 *
 */
public class JunitTest3 {
	
	@Ignore("Not Ready to Run")
	@Test
	public void divisionWithException(){
		System.out.println("Method is not ready yet");
	}
}
