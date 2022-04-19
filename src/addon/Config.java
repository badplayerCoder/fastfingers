/**
 * 
 */
package addon;

import java.io.File;
import java.time.LocalDateTime;

import model.Word;

/**
 * @author Lasse
 *
 */
public class Config implements ConfigIF{

	public boolean testing = false;
	public final String author = "Lasse Haslund";
	public final String version = "2.0";
	public final LocalDateTime now = LocalDateTime.now();  
	
	//private WriteToFile writeFile = new WriteToFile();
	
	//	Prints text into console as string
	public void printText(String text) {
		if(testing) {
			//writeFile.write
			System.out.println(text);
		}
	}
	
	//	Prints text into console as integer
	public void printInt(int amount) {
		if(testing) {
			//writeFile.writeIntegerToFile(amount);
			System.out.print(amount);
		}
	}
	
	//	Prints word into console as word(string)
	public void printWord(Word w) {
		if(testing) {
			System.out.println(w.getWord());
		}
	}
	
	//	Prints String & file into console
	public void printFile(String text, File file) {
		if(testing) {
			System.out.println(text + file);
		}
	}
	
	public void testTRUE() {
		testing = true;
	}
	
	public void testFALSE() {
		testing = false;
	}
	
}
