package addon;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	
	private Config config = new Config();
	
	public void createLogFile() {
		String currentPath = System.getProperty("user.home");
		String pathFolder = currentPath + "/Fastfingers";
		new File(currentPath,"/Fastfingers").mkdirs();
		try {
			//new File(currentPath,"/Fastfingers").mkdirs();
		    File file = new File(pathFolder, "fastfingerlogs.txt");
		    if (file.createNewFile()) {
		    	config.printText("File created: " + file.getName());
		    } else {
		    	config.printText("File already exists.");
		    }
		    }catch (IOException e) {
		    	config.printText("An error occurred.");
		    	e.printStackTrace();
		}
	}
	
	public void createWrongWordFile() {
		String currentPath = System.getProperty("user.home") + "/Fastfingers";
		//String pathFolder = currentPath + "/Fastfingers";
		try {
		      File myObj = new File(currentPath, "wrongwords.txt");
		      if (myObj.createNewFile()) {
		    	  config.printText("File created: " + myObj.getName());
		      } else {
		    	  config.printText("File already exists.");
		      }
		    } catch (IOException e) {
		    	config.printText("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public void createHighScore() {
		String currentPath = System.getProperty("user.home") + "/Fastfingers";
		try {
		      File myObj = new File(currentPath, "highscore.txt");
		      if (myObj.createNewFile()) {
		    	  config.printText("File created: " + myObj.getName());
		      } else {
		    	  config.printText("File already exists.");
		      }
		    } catch (IOException e) {
		    	config.printText("An error occurred.");
		      e.printStackTrace();
		}
	}
}
