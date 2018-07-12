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
common initialization to an @Before method

we extract the Criteria locals to a field that we initialize
in a new @Before method. We also eliminate the temporary result variable that
appears in each test.
*
*/

public class ProfileTest {

	private Profile profile;
	private Criteria criteria;

	private BooleanQuestion questionIsThereRelocation;

	private Answer answerThereIsRelocation;
	private Answer answerThereIsRelo;
	private Answer answerThereIsNotRelocation;
	private Answer answerDoesNotReimburseTuition;
	private Answer answerReimbursesTuition;

	@Before
	public void createCriteria() {
		criteria = new Criteria();
	}

	@Before
	public void createProfile() {
		profile = new Profile();
	}

	@Before
	public void addQuestionAndAnswer() {
		questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
		answerThereIsRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
	}

	@Before
	public void createQuestionAndAnswer() {
		questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
		answerThereIsRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
		answerThereIsNotRelocation = new Answer(questionIsThereRelocation, Bool.FALSE);
	}

	@Test
	public void matchesNothingWhenProfileEmpty() {

		Criterion criterion = new Criterion(new Answer(questionIsThereRelocation, Bool.TRUE), Weight.DontCare);


		assertFalse(profile.matches(profile.matches(criteria)));
	}

	@Test
	public void matchesWhenProfileContainsSameAnswerfromCriterion() {

		profile.add(answerThereIsRelocation);
		Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);


		assertTrue(profile.matches(criteria));
	}

	// matches returns false when the Profile instance
	// contains no matching Answer object:
	@Test
	public void noMatchesWhenProfileDoesNotContainAnyMatchingAnswer() {

		profile.add(answerThereIsNotRelocation);
		Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);

		assertFalse(profile.matches(criteria));

	}

	/*
	 * We take a quick look at the Answer class to see how to compare answers. We
	 * discover that it contains a match() method that takes an Answer as an
	 * argument and returns a boolean:
	 */
	@Test

	public void matchesWhenContainsMultipleAnswers() {
		profile.add(answerThereIsRelocation);
		profile.add(answerDoesNotReimburseTuition);
		Criterion criterion = new Criterion(answerThereIsRelocation, Weight.Important);
		
		assertTrue(profile.matches(criteria));
	}

	@Test
	public void matchesWhenAnyOfMultipleCriteriaMatch() {
		profile.add(answerThereIsRelo);
		
		criteria.add(new Criterion(answerThereIsRelo, Weight.Important));
		criteria.add(new Criterion(answerReimbursesTuition, Weight.Important));
		
		assertTrue(profile.matches(criteria));
	}

	@Test
	public void doesNotMatchWhenNoneOfMultipleCriteriaMatch() {

		profile.add(answerDoesNotReimburseTuition);

		criteria.add(new Criterion(answerThereIsRelo, Weight.Important));
		criteria.add(new Criterion(answerReimbursesTuition, Weight.Important));

		assertFalse(profile.matches(criteria));
	}

	//The next test: if any must-meet criteria are not met, return false:
	@Test
	public void doesNotMatchWhenAnyMustMeetCriteriaNotMet() {
	
	profile.add(answerThereIsRelo);
	profile.add(answerDoesNotReimburseTuition);
	
	criteria.add(new Criterion(answerThereIsRelo, Weight.Important));
	criteria.add(new Criterion(answerReimbursesTuition, Weight.MustMatch));
	
	assertFalse(profile.matches(criteria));

	}
}