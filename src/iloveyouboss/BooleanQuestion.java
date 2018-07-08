/*
 * 
 * 
 * 
 * 
 * 
 * 
 */
package iloveyouboss;

public class BooleanQuestion extends Question {
	public BooleanQuestion(int id,String text) {
		super (id, text, new String [] {"No", "Yes"});
	}
	
	@Override
	public boolean match(int expected, int actual) {
		// TODO Auto-generated method stub
		return expected == actual;
	}

}
