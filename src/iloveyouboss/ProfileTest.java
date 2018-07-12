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

/*We want the tests to stay short and
clear. Both our tests instantiate Profile. Create a Profile field and move the
common initialization to an @Before method*/

public class ProfileTest {
	 
	private Profile profile;
	
	@Before
	public void createProfile() {
		 profile = new Profile(); 
	}
	@Test
	public void matchesNothingWhenProfileEmpty() {
		Question question = new BooleanQuestion(1, "Relocation package?");
		Criterion criterion = 
				new Criterion(new Answer(question,Bool.TRUE), Weight.DontCare); 

		
		boolean result = profile.matches(criterion); 
		
		assertFalse(result); 
	}
	@Test
	public void matchesWhenProfileContainsSameAnswerfromCriterion() {

		Question question = new BooleanQuestion(1, "Relocation package?");
		Answer answer = new Answer(question, Bool.TRUE); 
		profile.add(answer); 
		Criterion criterion = 
				new Criterion(answer, Weight.Important); 

		
		boolean result = profile.matches(criterion); 
		
		assertTrue(result); 
	}
}