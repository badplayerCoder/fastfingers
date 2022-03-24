package controller;

import addon.Commands;
import addon.Terminal;
import addon.TerminalIF;
import gui.MainMenu;

public class TerminalController implements TerminalControllerIF{

	private Terminal terminal;
	private MainMenu mm;
	
	public TerminalController(MainMenu mm) {
		terminal = new Terminal();
		this.mm = mm;
	}
	
	public void terminalExecute(String text) {
		switch (text) {
		case "clearlog":
			terminal.executeAction(Commands.CLEAR_LOG_FILE);
			mm.clearTerminal();
			mm.changeTerminalFeedback("Cleared log file!");
			break;
		case "quit":
			terminal.executeAction(Commands.QUIT);
			break;
		case "clearwrong":
			terminal.executeAction(Commands.CLEAR_WRONG_FILE);
			mm.clearTerminal();
			mm.changeTerminalFeedback("Cleared Wrong words file!");
			break;
		case "clearhighscore":
			terminal.executeAction(Commands.CLEAR_HIGHSCORE);
			mm.clearTerminal();
			mm.changeTerminalFeedback("Cleared highscore file!");
			break;
		case "openhighscore":
			terminal.executeAction(Commands.OPEN_HIGHSCORE);
			mm.clearTerminal();
			mm.changeTerminalFeedback("Opened highscore file!");
			break;
		case "openwrong":
			terminal.executeAction(Commands.OPEN_WRONG_FILE);
			mm.clearTerminal();
			mm.changeTerminalFeedback("Opened wrong words file!");
			break;
		case "openfolder":
			terminal.executeAction(Commands.OPEN_FOLDER);
			mm.clearTerminal();
			mm.changeTerminalFeedback("Opened folder");
			break;
		case "debugtrue":
			terminal.executeAction(Commands.DEBUGTRUE);
			mm.clearTerminal();
			mm.changeTerminalFeedback("Debug mode = ON");
			break;
		case "openlog":
			terminal.executeAction(Commands.OPEN_LOG_FILE);
			mm.clearTerminal();
			mm.changeTerminalFeedback("Opened log file!");
			break;
		case "commands":
			terminal.executeAction(Commands.COMMANDS);
			mm.clearTerminal();
			mm.changeTerminalFeedback("");
			break;
		case "cmd":
			terminal.executeAction(Commands.CMD);
			mm.clearTerminal();
			mm.changeTerminalFeedback("");
			break;
		}
	}
	
}
