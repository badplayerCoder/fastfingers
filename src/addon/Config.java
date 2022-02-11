/**
 * 
 */
package addon;

import model.Word;

/**
 * @author Lasse
 *
 */
public class Config {

	public final boolean testing = true;
	
	//	Prints text into console as string
	public void printText(String text) {
		if(testing) {
			System.out.println(text);
		}
	}
	
	//	Prints text into console as integer
	public void printInt(int text) {
		if(testing) {
			System.out.print(text);
		}
	}
	
	//	Prints word into console as word(string)
	public void printWord(Word w) {
		if(testing) {
			System.out.println(w.getWord());
		}
	}
	
}
