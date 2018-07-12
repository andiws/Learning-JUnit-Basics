package iloveyouboss;

/*to make this test pass are small. Implement an add(Answer) method,
and have matches() return true as long as the Profile class holds a reference to
an Answer object:
*/

public class Profile {
	
	private Answer answer;

	public boolean matches(Criterion criterion) {
		// TODO Auto-generated method stub
		return  answer != null;
	}

	public void add(Answer answer) {
		// TODO Auto-generated method stub
		this.answer = answer;
	}

}
