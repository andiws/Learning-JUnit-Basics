package iloveyouboss;

import java.util.HashMap;
import java.util.Map;

public class Profile {
	/*to make this test pass are small. Implement an add(Answer) method,
	and have matches() return true as long as the Profile class holds a reference to
	an Answer object:
	
	
	*/
	private Map<String, Answer> answers = new HashMap<>();
	
	private Answer getMatchingProfileAnswer(Criterion criterion) {
		return answers.get(criterion.getAnswer().getQuestionText()); 
	}
	

	public boolean matches(Criterion criterion) {
		
		Answer answer = getMatchingProfileAnswer(criterion);
		return answer.match(criterion.getAnswer());
	}
	
	
	//This allows doesNotMatchWhenNoneOfMultipleCriteriaMatch() test to pass 
	public boolean matches(Criteria criteria) {
		return false;
		}	

	public void add(Answer answer) {
		answer.put(answer.getQuestionText(),answer); 
	}

	//The implementation requires a loop to iterate through each Criterion in Criteria:
	public boolean matches(Criteria criteria) {
		 for (Criterion criterion: criteria)
		 if (matches(criterion))
		return true;
		return false;
		}
}
