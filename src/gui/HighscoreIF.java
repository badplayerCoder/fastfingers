package gui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract interface HighscoreIF {
	public void setHighscore() throws FileNotFoundException;
	public List<Integer> getTop5();
	public boolean checkIfHigher(int amount);
}
