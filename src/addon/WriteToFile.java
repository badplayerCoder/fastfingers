package addon;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	private Config config = new Config();
	private String path = System.getProperty("user.home") + "/Fastfingers/";

	public void writeInformationToFile(String text) {
		try {
			FileWriter myWriter = new FileWriter(path + "fastfingerlogs.txt", true);
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
		try {
			FileWriter myWriter = new FileWriter(path + "fastfingerlogs.txt", true);
			myWriter.write("\n[Test] " + text);
			myWriter.close();
			config.printText("Successfully wrote to the file.");
		} catch (IOException e) {
			config.printText("An error occurred.");
			e.printStackTrace();
		}
	}

	/*
	 * Writes config integer into fastfingerlogs file
	 */
	public void writeIntegerToFile(int amount) {
		try {
			FileWriter myWriter = new FileWriter(path + "fastfingerlogs.txt", true);
			myWriter.write("\n[Test] " + amount);
			myWriter.close();
			config.printText("Successfully wrote to the file.");
		} catch (IOException e) {
			config.printText("An error occurred.");
			e.printStackTrace();
		}
	}

	public void writeWrongWordToFile(String right, String text) {
		try {
			FileWriter myWriter = new FileWriter(path + "wrongwords.txt", true);
			myWriter.write("\n[" + right + "]" + text);
			myWriter.close();
			config.printText("Successfully wrote to the file.");
		} catch (IOException e) {
			config.printText("An error occurred.");
			e.printStackTrace();
		}
	}

	public void writeWordToFile(String text) {
		try {
			FileWriter myWriter = new FileWriter(path + "fastfingerlogs.txt", true);
			myWriter.write("\n[Word] " + text);
			myWriter.close();
			config.printText("Successfully wrote to the file.");
		} catch (IOException e) {
			config.printText("An error occurred.");
			e.printStackTrace();
		}
	}

	public void writeHighScoreToFile(int correct) {
		try {
			FileWriter writer = new FileWriter(path + "highscore.txt", true);
			writer.write("\n"+correct);
			writer.close();
			config.printText("Successfully wrote to the file.");
		} catch (IOException e) {
			config.printText("An error occurred.");
		}
	}

	public void clearLogFile() {
		try {
			FileWriter writer = new FileWriter(path + "fastfingerlogs.txt");
			writer.close();
		}catch(IOException e) {
			config.printText("An error occurred.");
		}
	}
	
	public void clearWrongFile() {
		try {
			FileWriter writer = new FileWriter(path + "wrongwords.txt");
			writer.close();
		}catch(IOException e) {
			config.printText("An error occurred.");
		}
	}
	
	public void clearHighscoreFile() {
		try {
			FileWriter writer = new FileWriter(path + "highscore.txt");
			writer.close();
		}catch(IOException e) {
			config.printText("An error occurred.");
		}
	}
	
	public void onClosed(String text) {
		writeInformationToFile(text);
	}

	public void onOpen(String text) {
		writeInformationToFile(text);
	}
}
