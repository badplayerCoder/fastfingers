package addon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import gui.HighscoreIF;

public class Highscore implements HighscoreIF {

	private ArrayList<Integer> topScore;

	public Highscore() throws FileNotFoundException {
		topScore = new ArrayList<>();
	}

	public void setHighscore() throws FileNotFoundException {
		String currentPath = System.getProperty("user.home") + "/Fastfingers/";
		Scanner getInt = new Scanner(new File(currentPath + "highscore.txt"));
		
		topScore.clear();
		
		while (getInt.hasNext()) {
			if (getInt.hasNextInt()) {
				topScore.add(getInt.nextInt());
			} else {
				getInt.next();
			}
		}
	}

	public List<Integer> getTop5() {
		List<Integer> ph = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		
		for (int i = 0; i < topScore.size(); i++) {
			ph.add(topScore.get(i));
		}
		
		Collections.sort(ph, Collections.reverseOrder()); //	sort arraylist

		if(ph.size() < 5) {
			//	this is called if topScore arrayList.size is under 5, and copies topScore to res arraylist
			res = ph;
		}else {
			//	this is called if topScore arraylist.size is over 5 and adds the 5 first numbers in topScore to res arraylist
			for (int i = 0; i < 5; i++) {
				res.add(ph.get(i));
			}
		}
		return res;
	}
	
	public boolean checkIfHigher(int amount) {
		boolean res = false;
		List<Integer> resList = getTop5();
		for (Integer i : resList) {
			if (amount > i) {
				res = true;
			}
		}
		return res;
	}
}
