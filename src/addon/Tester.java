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
		WordController wc = new WordController();
		Word s1 = new Word("hey");
		Word s2 = new Word("hej");
		wc.addWord(s1);
		wc.addWord(s2);
		config.printWord(s1);
		config.printWord(s2);
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
