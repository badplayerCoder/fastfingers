/**
 * 
 */
package addon;

import controller.WordController;
import model.Word;

/**
 * @author Lasse
 *
 */
public class Tester {

	private Config config;
	
	public Tester() {
		init();
		Setup();
	}
	
	public void Setup() {
		WordController wc = new WordController();
		wc.newWord("hey");
		wc.newWord("hej");
	}
	
	public void testWord() {
		Word s1 = new Word("hey");
		WordController wc = new WordController();
		wc.addWord(s1);
	}
	
	private void init() {
		config = new Config();
	}
	
}
