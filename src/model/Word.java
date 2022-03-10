/**
 * 
 */
package model;

/**
 * @author Lasse Haslund
 *
 */
public class Word {

	//	Variables for word
	
	private String word;
	
	
	/**
	 * 	Constructor of word class
	 * 	@param word given string text to create new word class with given string word
	 */
	public Word(String word) {
		this.word = word;
	}
	
	/**
	 * 	Word getter
	 * 	@return word	returns the string word given to the class of the start
	 */
	public String getWord() {
		return word;
	}
	
}
