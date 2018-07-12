/*
 * 
 * 
 * 
 * 
 * 
 * 
 */
package iloveyouboss;

public class Answer {
	private int i; 
	private Question question; 
	
	public Answer (Question question, int i) {
		this.question = question; 
		this.i = i; 
	}
	
	public Answer (Question question, String matchingValue) {
		this.question = question; 
		this.i = question.indexOf(matchingValue); 
	}
		
	public String getQuestionText() {
		return question.getText(); 
	}
	
	@Override 
	public String toString() {
		return String.format("%s %s", question.getText(), question.getAnswerChoice(i)); 
	}
	
	public boolean match(int expected) {
		return question.match(expected,i);
	}
		
	public boolean match(Answer otherAnswer) {
		//The passing implementation in matches() is a simple guard clause: return false
		//if the passed Answer reference is null
		if (otherAnswer == null) return false;
		
		return question.match(i,otherAnswer.i); 
		
	}

	public void put(String questionText, Answer answer) {
		// TODO Auto-generated method stub
		
	}
}
