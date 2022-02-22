/**
 * 
 */
package controller;

import javax.swing.JLabel;

import addon.Config;
import addon.Score;
import gui.GameGUI;
import model.Word;

/**
 * @author Lasse
 *
 */
public class GameController {

	private WordController wordController;
	private Score score;
	private Config config;
	
	private String lblFirst;
	private String lblSecond;
	private String lblThird;
	
	public GameController() {
		init();
	}
	
	/*
	 * 	Methods to randomize lblFirst, lblSecond & lblThird when being called
	 */
	
	public String setLabelFirst() {
		Word word = null;
		word = wordController.randomWord();
		
		this.lblFirst = word.getWord();
		
		return lblFirst;
	}
	
	public String setLabelSecond() {
		Word word = null;
		word = wordController.randomWord();
		
		this.lblSecond = word.getWord();
		
		return lblSecond;
	}
	
	public String setLabelThird() {
		Word word = null;
		word = wordController.randomWord();
		
		this.lblThird = word.getWord();
		
		return lblThird;
	}
	
	/*
	 * 	The logic for textField at gameGUI to check if the input is the same as lblFirst
	 * 	@Returns true if textfield's input as lblFirst
	 */
	
	public boolean checkTextBox(String text) {
		boolean check = false;
		if(text.equals(lblFirst.toString())) {
			moveTextToNewRow();
			score.addCorrect();
			check = true;
		}else {
			score.addWrong();
		}
		return check;
	}
	
	/*
	 * 	Method to move labels in the row from last to first
	 */
	
	public void moveTextToNewRow() {
		lblFirst = lblSecond; //Moves second word to first
		lblSecond = lblThird; //Clears lbl second
		lblThird = null;
		if(lblThird == null) {
			lblThird = setLabelThird();
		}
	}
	
	
	/*
	 * 	Getters
	 */
	
	public String getFirst() {
		return lblFirst;
	}
	
	public String getSecond() {
		return lblSecond;
	}
	
	public String getThird() {
		return lblThird;
	}
	
	/*
	 * 	Init
	 */
	
	private void init() {
		wordController = new WordController();
		score = new Score();
		config = new Config();
	}
	
	/*
	 * 	Score
	 */
	
	public int getCorrect() {
		return score.getCorrect();
	}
	
	public int getWrong() {
		return score.getWrong();
	}
	
	public double getProcent() {
		return score.getProcent();
	}
	
}
