/**
 * 
 */
package controller;

import javax.swing.JLabel;

import gui.GameGUI;
import model.Word;

/**
 * @author Lasse
 *
 */
public class GameController {

	private WordController wordController;
	
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
			check = true;
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
	
	public String getFirst() {
		return lblFirst;
	}
	
	public String getSecond() {
		return lblSecond;
	}
	
	private void init() {
		wordController = new WordController();
	}
	
}
