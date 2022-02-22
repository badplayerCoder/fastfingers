/**
 * 
 */
package controller;

import javax.swing.JLabel;

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
	
	private String lblFirst;
	private String lblSecond;
	
	public GameController() {
		init();
	}
	
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
	
	public boolean checkTextBox(String text) {
		boolean check = false;
		if(text.equals(lblFirst.toString())) {
			moveSecondToFirst();
			score.addCorrect();
			check = true;
		}else {
			score.addWrong();
		}
		return check;
	}
	
	public void moveSecondToFirst() {
		lblFirst = lblSecond; //Moves second word to first
		lblSecond = null; //Clears lbl second
		if(lblSecond == null) {
			lblSecond = setLabelSecond();
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
	
	/*
	 * 	Init
	 */
	
	private void init() {
		wordController = new WordController();
		score = new Score();
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
	
	public int getProcent() {
		return score.getProcent();
	}
	
}
