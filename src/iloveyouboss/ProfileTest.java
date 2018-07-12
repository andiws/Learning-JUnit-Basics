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
	private BooleanQuestion questionIsThereRelocation;
	private Answer answerThereIsRelocation;
	private Answer answerThereIsNotRelocation; 
	
	@Before
	public void createProfile() {
		 profile = new Profile(); 
	}
	
	@Before
	public void addQuestionAndAnswer() {
		 questionIsThereRelocation = 
				 new BooleanQuestion(1, "Relocation package?");
		answerThereIsRelocation = 
				new Answer(questionIsThereRelocation, Bool.TRUE);
	}
	
	@Before
	public void createQuestionAndAnswer() {
		questionIsThereRelocation =
		new BooleanQuestion(1, "Relocation package?");
		answerThereIsRelocation =
		new Answer(questionIsThereRelocation, Bool.TRUE);
		answerThereIsNotRelocation =
		new Answer(questionIsThereRelocation, Bool.FALSE);
		}
	
	@Test
	public void matchesNothingWhenProfileEmpty() {

		Criterion criterion = 
				new Criterion(new Answer(questionIsThereRelocation,Bool.TRUE), Weight.DontCare); 

		
		boolean result = profile.matches(criterion); 
		
		assertFalse(result); 
	}
	@Test
	public void matchesWhenProfileContainsSameAnswerfromCriterion() {


		profile.add(answerThereIsRelocation); 
		Criterion criterion = 	
				new Criterion(answerThereIsRelocation, Weight.Important); 

		
		boolean result = profile.matches(criterion); 
		
		assertTrue(result); 
	}
	//matches returns false when the Profile instance
	//contains no matching Answer object:
	@Test
	public void noMatchesWhenProfileDoesNotContainAnyMatchingAnswer() {
		
		profile.add(answerThereIsNotRelocation); 
		Criterion criterion = 	
				new Criterion(answerThereIsRelocation, Weight.Important); 

		 	
		boolean result = profile.matches(criterion); 
		
		assertFalse(result); 
	
	}
	/*We take a
quick look at the Answer class to see how to compare answers. We discover
that it contains a match() method that takes an Answer as an argument and
returns a boolean:*/
}