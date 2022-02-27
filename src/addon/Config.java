/**
 * 
 */
package addon;

import java.time.LocalDateTime;

import model.Word;

/**
 * @author Lasse
 *
 */
public class Config {

	public final boolean testing = false;
	public final String author = "Lasse Haslund";
	public final String version = "1.2";
	public final LocalDateTime now = LocalDateTime.now();  
	
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
