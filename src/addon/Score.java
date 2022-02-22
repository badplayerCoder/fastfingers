/**
 * 
 */
package addon;

/**
 * @author lassehas
 *
 */
public class Score {
	
	//	Variables
	private int correct;
	private int wrong;
	
	/*
	 * 	Constructor
	 */
	
	public Score() {
		this.correct = 0;
		this.wrong = 0;
	}
	
	/*
	 * 	Getters
	 */
	
	public int getCorrect() {
		return correct;
	}
	
	public int getWrong() {
		return wrong;
	}
	
	/*
	 * 	Setters
	 */
	
	public void addCorrect() {
		correct++;
	}
	
	public void addWrong() {
		wrong++;
	}
	
	/*
	 * 	Methods
	 */
	
	public int getProcent() {
		int procent = 0;
		if(correct == 0 && wrong == 0) {
			//Nothing
		}else {
			procent = (correct / (correct + wrong)) * 100;
		}
		
		return procent; 
	}
	
}
