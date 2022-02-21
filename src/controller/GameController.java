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
	private GameGUI gameGUI;
	
	private String lblFirst;
	private String lblSecond;
	
	public GameController() {
		init();
	}
	
	public void setLabelFirst() {
		Word word = null;
		word = wordController.randomWord();
		
		this.lblFirst = word.getWord();
		gameGUI.setFirst(lblFirst);
	}
	
	public void checkTextBox(String text) {
		if(text.equals(lblFirst.toString())) {
			clearTextBox();
			moveSecondToFirst();
		}
	}
	
	public void clearTextBox() {
		
	}
	
	public void moveSecondToFirst() {
		
	}
	
	private void init() {
		wordController = new WordController();
		//gameGUI = new GameGUI();
	}
	
}
