package addon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import gui.HighscoreIF;

public class Highscore implements HighscoreIF{

	private ArrayList<Integer> topScore;
	private int top1;

	public Highscore() throws FileNotFoundException {
		topScore = new ArrayList<>();	
	}

	public void setHighscore() throws FileNotFoundException {
		String currentPath = System.getProperty("user.home") + "/Fastfingers/";
		Scanner getInt = new Scanner(new File(currentPath + "highscore.txt"));
		while (getInt.hasNext()) {
			if (getInt.hasNextInt()) {
				topScore.add(getInt.nextInt());
			} else {
				getInt.next();
			}
		}
	}

	public int getTop() {
		ArrayList<Integer> top = new ArrayList<>();
		int highest = 0;
		
		for (int i = 0; i < topScore.size(); i++) {
			if(topScore.get(i) > top1) {
				top1 = topScore.get(i);
			}
		}
		
		top.add(top1);
		
		highest = top.get(0);
		
		return highest;
	}

	
	
	
	
}
