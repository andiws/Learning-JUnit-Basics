package iloveyouboss;
 import java.util.*; 
 
public class ScoreCollection {
	private List <Scoreable> scores = new ArrayList<> (); 
	
	public void add(Scoreable scoreable) {
		scores.add(scoreable);
	}
	
	public int arithmeticMean() {
//		int total = scores.stream().mapToInt(Scoreable::getScore).sum();
		
		int total=0; 
		
		for (Scoreable Temp : scores)
		{
		//Temp.getScore() + total;
		total += Temp.getScore(); 
		}		
		
		return total/scores.size(); 
	}
	
	
	

}
