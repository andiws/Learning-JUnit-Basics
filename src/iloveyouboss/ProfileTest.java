/*
 * 
 * 
 * 
 * 
 * 
 * 
 */
package iloveyouboss;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 

public class ProfileTest {
	@Test
	public void matchesNothingWhenProfileEmpty() {
		Profile profile = new Profile();
		Question question = new BooleanQuestion(1, "Relocation package?");
		Criterion criterion = 
				new Criterion(new Answer(question,Bool.TRUE), Weight.DontCare); 

		
		boolean result = profile.matches(criterion); 
		
		assertFalse(result); 
	}
}