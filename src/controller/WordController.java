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
	
	/**
	 * 	Constructor & it is created when the class is called  
	 */
	
	public WordController() {
		wordContainer = WordContainer.getInstance();
		init();
	}
	
	/**
	 * 	Creates new word & adds it to arraylist from the wordContainer
	 * @param text	is used to check if the 'text' is in the system or not.
	 * @return	false as default. true if parameter 'text' isnt in the system.
	 */
	public boolean newWord(String text) {
		boolean success = false;
		if(wordContainer.newWord(text)) {
			success = true;
		}
		return success;
	}
	
	/**
	 *	Finds & returns word with given text
	 *	@return	word	null as default. returns word object if it is in the system
	 */
	
	public Word findWord(String text) {
		Word word = null;
		word = wordContainer.findWord(text);
		return word;
	}
	
	/*
	 * 	Removes word with given parameter
	 */
	
	public void removeWord(String text) {
		wordContainer.removeWord(text);
	}
	
	/*
	 * 	Returns random word from list	
	 */
	
	public Word randomWord() {
		Word word = null;
		
		word = wordContainer.randomWord();
		
		return word;
	}
	
	/*
	 * 	Adds word to wordContainer 
	 */
	
	public void addWord(Word w) {
		wordContainer.addWord(w);
	}
	
	/*
	 * 	Calls methods from wordcontainer to print all words
	 */
	
	private void printWords() {
		wordContainer.printWords();
	}
	
	/*
	 * 	Returns the amount of words in the database atm as int
	 */
	
	public int getAmountWords() {
		return wordContainer.getAmountWords();
	}
	
	/*
	 * 	Drops all words in the container to make room for new words
	 */
	
	public void dropDB() {
		wordContainer.dropDB();
	}
	
	/*
	 * 	Init 
	 */
	
	private void init() {
		Config config = new Config();
		config.printText("Init word controller called");
		printWords();
	}
}
