/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Lasse
 *
 */
public class WordContainer {

	private static WordContainer instance;
	
	private ArrayList<String> words;
	
	/*
	 * 	Constructor for the wordcontainer class
	 * 	Constructor is a singleton, so can be used once at the time
	 */
	
	private WordContainer() {
		words = new ArrayList<>();
	}
	
	public static WordContainer getInstance() {
		if(instance == null) {
			instance = new WordContainer();
		}
		return instance;
	}
	
	//	Add word to the arraylist
	public void addWord(String word) {
		words.add(word);
	}
	
	//	Removes word from arraylist
	public void removeWord(String word) {
		words.remove(word);
	}
	
	//	Creates new word & adds it to arraylist
	public void newWord(String text) {
		String word = text;
		addWord(word);
	}
	
	//	Search for word by input text
	public String findWord(String text) {
		String word = null;
		
		for(String s : words.split("\\s+")) {
			if(s == text) {
				word = s;
				break;
			}
		}
		
		return word;
	}
}
