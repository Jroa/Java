/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.*;

/**
 * @author Jonathan
 *
 */
public class JunitTest1 {

	private Collection collection;
	
	@BeforeClass
	public static void oneTimeSetup(){
		//one-time initialization code
		System.out.println("@BeforeClass - oneTimeSetup");
	}
	
	@AfterClass
	public static void oneTearDown(){
		//one-time cleanup code
		System.out.println("@AfterClass - oneTimeTearDown");
	}
	
	
	@Before
	public void setUp(){
		collection = new ArrayList();
		System.out.println("@Before - setUp");
	}
	
	@After
	public void tearDown(){
		collection.clear();
		System.out.println("@After - tearDown");
	}
	
	@Test
	public void testEmptyCollection(){
		assertTrue(collection.isEmpty());
		System.out.println("@Test - testEmptyCollection");
	}
	
	@Test
	public void testOneItemCollection(){
		collection.add("itemA");
		assertEquals(1,collection.size());
		System.out.println("@Test - testOneItemCollection");
	}
}
