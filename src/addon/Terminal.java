package addon;

import java.io.IOException;

import gui.WindowManager;

public class Terminal {

	
	private WriteToFile write;
	private OpenFile open;
	private ConfigIF cfg;
	private WindowManager windowManager;

	public Terminal() {
		write = new WriteToFile();
		open = new OpenFile();
		cfg = new Config();
		windowManager = new WindowManager();
	}

	public void executeAction(Commands cmd) {
		switch (cmd) {
		case CLEAR_LOG_FILE:
			write.clearLogFile();
			break;
		case CLEAR_HIGHSCORE:
			write.clearHighscoreFile();
			break;
		case CLEAR_WRONG_FILE:
			write.clearWrongFile();
			break;
		case QUIT:
			System.exit(0);
			break;
		case OPEN_HIGHSCORE:
			try {
				open.openHighscore();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case OPEN_WRONG_FILE:
			try {
				open.openWrong();
			} catch (Exception e) {
			}
			break;
		case OPEN_FOLDER:
			try {
				open.openFolder();
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case DEBUGTRUE:
			cfg.testTRUE();
			break;
		case OPEN_LOG_FILE:
			try {
				open.openLog();
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case COMMANDS:
			windowManager.goCommandDialog();
			break;
		case CMD:
			windowManager.goCommandDialog();
			break;
		}
	}

}
