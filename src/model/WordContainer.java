/**
 * 
 */
package model;

import java.util.ArrayList;
import addon.Config;

/**
 * @author Lasse
 *
 */
public class WordContainer {

	private static WordContainer instance;
	
	private ArrayList<Word> words;
	
	private Config config;
	
	/*
	 * 	Constructor for the wordcontainer class
	 * 	Constructor is a singleton, so can be used once at the time
	 */
	
	private WordContainer() {
		words = new ArrayList<>();
		config = new Config();
	}
	
	public static WordContainer getInstance() {
		if(instance == null) {
			instance = new WordContainer();
		}
		return instance;
	}
	
	//	Add word to the arraylist
	public void addWord(Word word) {
		words.add(word);
	}
	
	//	Removes word from arraylist
	public void removeWord(Word word) {
		words.remove(word);
	}
	
	//	Creates new word & adds it to arraylist
	public void newWord(String text) {
		if(findWord(text).getWord() == text) {
			config.printText("The entered word is already added");
		}else {
			Word word = new Word(text);
			addWord(word);
		}
		
	}
	
	//	Search for word by input text
	public Word findWord(String text) {
		Word word = null;
		
		for(Word s : words) {
			config.printText("findWord for each loop");
			config.printWord(s);
			if(s.getWord() == text) {
				word = s;
				break;
			}
		}
		
		return word;
	}
	
	public void printWords() {
		//Prints all words into console
		for(Word w : words) {
			config.printWord(w);
		}
	}
}
