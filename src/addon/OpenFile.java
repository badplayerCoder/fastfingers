package addon;

import java.io.IOException;

public class OpenFile {

	private String path = System.getProperty("user.home") + "/Fastfingers/";
	
	public void openLog() throws IOException {
		//	Gets file & path for the folder dir
		String file = "fastfingerlogs.txt";
		String folder = System.getProperty("user.home") + "/Fastfingers/" + file;
		
		//	Creates ProcessBuilder.
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("open", folder);
		pb.start();
	}
	
	public void openWrong() throws IOException {
		//	Gets file & path for the folder dir
		String file = "wrongwords.txt";
		
		//	Creates ProcessBuilder.
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("open", path+file);
		pb.start();
	}
	
	public void openHighscore() throws IOException {
		//	Gets file & path for the folder dir
		String file = "highscore.txt";
		
		//	Creates ProcessBuilder.
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("open", path+file);
		pb.start();
	}
	
	public void openFolder() throws IOException {
		//	Creates ProcessBuilder.
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("open", path);
		pb.start();
	}
	
}
