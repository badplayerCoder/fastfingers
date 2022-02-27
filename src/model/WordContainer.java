/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Random;

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
		if(findWord(text) == null) {
			Word word = new Word(text);
			addWord(word);
			config.printText(word.getWord() + " Has been added");
		}else {
			config.printText("The entered word is already added");
		}
		
	}
	
	//	Search for word by input text
	public Word findWord(String text) {
		Word word = null;
		
		for(Word s : words) {
			config.printText("findWord for each loop");
			config.printWord(s);
			if(s.getWord().equals(text)) {
				word = s;
				config.printWord(word);
				break;
			}
		}
		
		return word;
	}
	
	/*
	 * 	Drops all words in the arrayList to make room to new words
	 * 	Use with care! It will clear the whole arraylist
	 */
	
	public void dropDB() {
		words.clear();
		config.printText("Word database has been cleared and now is empty");
	}
	
	public Word randomWord() {
		//	Create instance of Random class
		Random random = new Random();
		
		//	Create new word & set it to null
		Word word = null;
		
		//	Randomize index for the size of words arraylist
		int index = random.nextInt(words.size());
		
		//	Sets word from words arraylist with the randomized index
		word = words.get(index);
		
		//	Returns the random word
		return word;
	}
	
	/*
	 * 	Prints all words of this container
	 */
	
	public void printWords() {
		//Prints all words into console
		for(Word w : words) {
			config.printWord(w);
		}
	}
	
	public int getAmountWords() {
		//Returns the count of words
		int sum = 0;
		//Foreach loop to + sum up
		for(Word w : words) {
			sum++;
		}
		//Returns the sum
		return sum; 
	}
}
