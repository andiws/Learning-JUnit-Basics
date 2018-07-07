package iloveyouboss;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 

public class ProfileTest {
	private Profile profile;
	private Criteria criteria; 
	
	private Question questionReimbursesTuition; 
	private Answer answerReimbursesTution;
	private Answer answerDoesNotReimburseTuition; 
	
	private Question questionIsThereRelocation;
	private Answer answerThereIsRelocation;
	private Answer answerThereIsNoRelocation; 
	
	private Question questionOnsiteDaycare; 
	private Answer answerNoOnsiteeDaycare;
	private Answer answerHasOnsiteDaycare; 
	
	
	@Before
	public void createProfile() {
		profile = new Profile("Bull Hockey, Inc."); 
	}
	
	@Before
	public void createCriteria () {
		criteria = new Criteria(); 
	}
	
	@Before
	public void createQuestonsAndAnswers() {
		questionIsThereRelocation =
				new BooleanQuestion(1, "Relocation package?");
		answerThereIsRelocation = 
				new Answer (questionIsThereRelocation,Bool.TRUE); 
		answerThereIsNoRelocation = 
				new Answer(questionIsThereRelocation,Bool.FALSE);
		
		questionReimbursesTuitioin = 
				new BooleanQuestion(1, "Reimburses tuition?");
		answerReimburseTuition = 
				new Answer(questionReimbursesTuition, Bool.TRUE); 
		answerReimbursesTuition = 
				new Answser(questionReimbursesTuition, Bool.FALSE); 
		
		questionOnsiteDaycare = 
				newBooleanQuestion(1, "Onsite Daycare?"); 
		answerHasOnsiteDaycare = 
				new Answer(questionOnsiteDay, Bool.TRUE); 
		answerHasOnsiteDaycare = 
				new Answer(questionOnsiteDay, Bool.FALSE); 
	}

	@Test
	public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		profile.add(answerDoesNotReimburseTuition);
		criteria.add(
				new Criterion(answerReimbursesTuition, Weight.MustMatch); 

		boolean matches = profile.matches(criteria);
		assertFalse(matches); 
	}
	
	@Test
	public void matchAnswersTrueForAnyDontCareCriteria() {
		profile.add(answerDoesNotReimburseTuition);
		criteria.add(
				new Criterion(answerReimbursesTuition, Weight.DontCare); 

		boolean matches = profile.matches(criteria);
		assertTrue(matches); 
	}
	@Test 
	public void matchAnswersTrueWhenAnyOfMultipleCriteriaMatch() {
		profile.add(answerThereIsRelocation);
		profile.add(answerDoesNotReimburseTuition);
		criteria.add(new Criterion(answerThereIsRelocatioin, Weight.Important));
		criteria.add(new Criterion(answerReimbursesTuition, Weight.Important));
		
		boolean matches = profile.matches(criteria);
		
		assertTrue(matches);
		
	}
	@Test 
	public void matchAnswersFalseWhenNoneOfMultipleCriteriaMatch() {
		profile.add(answerThereIsNoRelocation);
		profile.add(answerDoesNotReimburseTuition);
		criteria.add(new Criterion(answerThereIsRelocatioin, Weight.Important));
		criteria.add(new Criterion(answerReimbursesTuition, Weight.Important));
		
		boolean matches = profile.matches(criteria);
		
		assertFalse(matches);
	}
	
	@Test
	public void scoreIsZeroWhenThereAreNoMatches() {
		profile.add(answerThereIsNoRelocation);
		criteria.add(new Criterion(answerThereIsRelocation,Weight.Important)); 
		
		profile.matches(criteria); 
		
		assertThat(profile.score(), equalTo(0)); 
		
	}
	@Test
	public void scoreIsCriterionValueForSingleMatch() {
		profile.add(answerThereIsRelocation);
		criteria.add(new Criterion(answerThereIsRelocation,Weight.Important)); 
		
		profile.matches(criteria); 
		
		assertThat(profile.score(), equalTo(Weight.Important.getValue()); 
		
	}

	@Test
	public void scoreAccumulatesCriterionValuesForMatches() {
		profile.add(answerThereIsRelocation);
		profile.add(answerReimbursesTuition);
		profile.add(answerNoOnsiteDaycare);
		criteria.add(new Criterion (answerThereIsRelocation, Weight.Important));
		criteria.add(new Criterion (answerThereIsRelocation, Weight.WouldPrefer));
		criteria.add(new Criterion (answerThereIsRelocation, Weight.VeryImportant));
		
		profile.matches(criteria);
		
		int expectedScore = Weight.Important.getValue() + Weight.WouldPrefer.getValue(); 
		assertThat(profile.score(), equalTo(expectedScore));
	}
	//TODO: missing functionality -- what if there is no match profile answer for a criterion? 
	//Add another answer - either "other" or textbox 
}