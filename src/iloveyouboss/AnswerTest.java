package iloveyouboss;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AnswerTest {
	
	@Test
	public void matchAgainstNullAnswerReturnsFalse() {
		
	
	assertFalse(new Answer(new BooleanQuestion(0, ""), Bool.TRUE)
	.match(null));
	}
	
	/*rather than code answer.match(criterion.getAnswer()), we can code criterion.
getAnswer().match(answer), because criterion.getAnswer() returns a non-null value
See Answer.java for The passing implementation in matches() is a simple guard clause: return false
if the passed Answer reference is null.
*/

	@Test
	public void testTheRelationship() {
		Question sky = new BooleanQuestion(12, "Is the sky blue?");
		
		Answer rightAnswer = new Answer(sky, "Yes");
		
		Answer andi = new Answer(sky, "No");
		
		
		assertFalse(rightAnswer.match(andi));
		
		
		
	}
	
	
}
