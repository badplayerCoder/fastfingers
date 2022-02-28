package addon;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	private Config config = new Config();
	
	public void writeInformationToFile(String text) {
		String currentPath = System.getProperty("user.home");
		String pathFolder = currentPath + "/Fastfingers/";
		try {
		      FileWriter myWriter = new FileWriter(pathFolder + "fastfingerlogs.txt", true);
		      myWriter.write("\n[" + text + "]");
		      myWriter.close();
		      config.printText("Successfully wrote to the file.");
		    } catch (IOException e) {
		    	config.printText("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	/*
	 * Writes config information into fastfingerlogs file
	 */
	public void writeStringToFile(String text) {
		String currentPath = System.getProperty("user.home");
		String pathFolder = currentPath + "/Fastfingers/";
		try {
		      FileWriter myWriter = new FileWriter(pathFolder + "fastfingerlogs.txt", true);
		      myWriter.write("\n[Test] " + text);
		      myWriter.close();
		      config.printText("Successfully wrote to the file.");
		    } catch (IOException e) {
		    	config.printText("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	/*
	 * 	Writes config integer into fastfingerlogs file
	 */
	public void writeIntegerToFile(int amount) {
		String currentPath = System.getProperty("user.home");
		String pathFolder = currentPath + "/Fastfingers/";
		try {
		      FileWriter myWriter = new FileWriter(pathFolder + "fastfingerlogs.txt", true);
		      myWriter.write("\n[Test] " + amount);
		      myWriter.close();
		      config.printText("Successfully wrote to the file.");
		    } catch (IOException e) {
		    	config.printText("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public void writeWrongWordToFile(String right, String text) {
		String currentPath = System.getProperty("user.home");
		String pathFolder = currentPath + "/Fastfingers/";
		try {
		      FileWriter myWriter = new FileWriter(pathFolder + "wrongwords.txt", true);
		      myWriter.write("\n[" + right + "]" + text);
		      myWriter.close();
		      config.printText("Successfully wrote to the file.");
		    } catch (IOException e) {
		    	config.printText("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public void writeWordToFile(String text) {
		String currentPath = System.getProperty("user.home");
		String pathFolder = currentPath + "/Fastfingers/";
		try {
		      FileWriter myWriter = new FileWriter(pathFolder + "fastfingerlogs.txt", true);
		      myWriter.write("\n[Word] " + text);
		      myWriter.close();
		      config.printText("Successfully wrote to the file.");
		    } catch (IOException e) {
		    	config.printText("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public void onClosed(String text) {
		writeInformationToFile(text);
	}
	
	public void onOpen(String text) {
		writeInformationToFile(text);
	}
}
