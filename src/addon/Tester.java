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

	public void testWord() {
		String s1 = "hey";
		String newWord = s1;
		WordController wc = new WordController();
		wc.addWord(newWord);
	}
	
}
