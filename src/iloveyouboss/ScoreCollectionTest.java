package iloveyouboss;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.*;

public class ScoreCollectionTest {

	@Test

	public void answersArithmeticMeanOfTwoNubers() {
		//Arrange
		ScoreCollection collection = new ScoreCollection (); 
		collection.add(()-> 5); 
		collection.add(() -> 7);
		
		//Act or "execute" method
		int actualResult = collection.arithmeticMean();
		
		//Assert
		assertThat(actualResult, equalTo(6)); 
		
	}
}