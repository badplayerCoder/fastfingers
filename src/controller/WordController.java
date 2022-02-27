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
	
	/*
	 * 	Constructor & it is created when the class is called  
	 */
	
	public WordController() {
		wordContainer = WordContainer.getInstance();
		init();
	}
	
	//	Creates new word & adds it to arraylist from the wordContainer
	public void newWord(String text) {
		//	Checks if the word is already added
		wordContainer.newWord(text);
	}
	
	/*
	 *	Finds & returns word with given text	
	 */
	
	public Word findWord(String text) {
		Word word = findWord(text);
		return word;
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
		config = new Config();
		config.printText("Init word controller called");
		printWords();
	}
}
