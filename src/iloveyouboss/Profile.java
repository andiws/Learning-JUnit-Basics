package iloveyouboss;

public class Profile {
	/*to make this test pass are small. Implement an add(Answer) method,
	and have matches() return true as long as the Profile class holds a reference to
	an Answer object:
	*/
	private Answer answer;

	public boolean matches(Criterion criterion) {
		// TODO Auto-generated method stub
		return  answer != null &&
				answer.match(criterion.getAnswer());
	}

	public void add(Answer answer) {
		// TODO Auto-generated method stub
		this.answer = answer;
	}

}
