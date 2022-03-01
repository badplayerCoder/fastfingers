package addon;

import java.io.IOException;

public class OpenFile {

	public void openLog() throws IOException {
		//	Gets file & path for the folder dir
		String file = "fastfingerlogs.txt";
		String folder = System.getProperty("user.home") + "/Fastfingers/" + file;
		
		//	Creates ProcessBuilder.
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("open", folder);
		pb.start();
	}
	
	public void openFolder() throws IOException {
		//	Gets the path of the folder dir
		String folder = System.getProperty("user.home") + "/Fastfingers/";
		
		//	Creates ProcessBuilder.
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("open", folder);
		pb.start();
		
	}
	
}
