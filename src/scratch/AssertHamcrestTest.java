/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
package scratch;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.io.*; 
import java.util.*;
import org.junit.*;
import static scratch.PointMatcher.isNear;

import org.junit.rules*; 

public class AssertHamcrestTest {

	@Test
	public void test() {
		assertThat(2.32*3, equalTo(6.96));	
		}
//	assertTrue(Math.abs((2.32*3)-6.96) < 0.0005); 
//	
//	assertTrue(2.32*3, closeTo(6.96,0.0005)); 
}
