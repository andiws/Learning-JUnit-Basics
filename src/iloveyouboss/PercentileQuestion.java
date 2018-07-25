/*
 * 
 * 
 * 
 * 
 * 
 * 
 */
package iloveyouboss;

public class PercentileQuestion extends Question {
	public PercentileQuestion(int id, String text, String [] answerChoices) {
		super(id, text, answerChoices);
	}

	@Override
	public boolean match(int expected, int actual) {
		// TODO Auto-generated method stub
		return false;
		// return expected >= actual;  
	}
	
	/*A cross-check might involve finding the complement of the predicate—answers
whose questions are not of type PercentileQuestion. The positive-case answers
and the inverse answers should combine to represent all the answers:*/

}
