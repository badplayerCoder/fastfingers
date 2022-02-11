/**
 * 
 */
package controller;

import model.Word;
import model.WordContainer;
import addon.Config;

/**
 * @author Lasse
 *
 */
public class WordController {

	private WordContainer wordContainer;
	private Config config;
	
	public WordController() {
		wordContainer = WordContainer.getInstance();
		init();
	}
	
	//	Creates new word & adds it to arraylist from the wordContainer
	public void newWord(String text) {
		//	Checks if the word is already added
		wordContainer.newWord(text);
		config.printText(text + " has been added ");
		/*if(findWord(text) == null) {
			wordContainer.newWord(text);
			config.printText(text + " has been added ");
		}else {
			config.printText("The entered word is already added");
		}*/
	}
	
	public String findWord(String text) {
		String word = findWord(text);
		return word;
	}
	
	public void addWord(String w) {
		wordContainer.addWord(w);
	}
	
	private void init() {
		config = new Config();
	}
}
