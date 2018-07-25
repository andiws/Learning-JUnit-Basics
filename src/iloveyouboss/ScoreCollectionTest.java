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
	
	@Test
	public void answersArithmeticMeanOfFourNumbers() {
		

	ScoreCollection collection = new ScoreCollection (); 
	collection.add(()-> 8); 
	collection.add(() -> 12);
	collection.add(()-> 8); 
	collection.add(() -> 12);
	
	//Act or "execute" method
	int actualResult = collection.arithmeticMean();
	
	//Assert
	assertThat(actualResult, equalTo(10)); 
	
}

	@Test
	public void answersArithmeticMeanOfNegativeNumbers() {
		

	ScoreCollection collection = new ScoreCollection (); 
	collection.add(()-> -10); 
	collection.add(() -> 2);
	collection.add(()-> -10); 
	collection.add(() -> 2);
	
	//Act or "execute" method
	int actualResult = collection.arithmeticMean();
	
	//Assert
	assertThat(actualResult, equalTo(-4)); 
	
}
	
}