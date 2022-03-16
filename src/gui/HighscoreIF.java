package gui;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract interface HighscoreIF {
	public void setHighscore() throws FileNotFoundException;
	public int getTop();
}
