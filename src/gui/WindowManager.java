/**
 * 
 */
package gui;

import javax.swing.JFrame;

/**
 * @author Lasse
 *
 */
public class WindowManager {

	
	/*
	 * 	Changes the window to main menu
	 */
	
	public void goMainMenu() {
		MainMenu mm = new MainMenu();
		mm.setLocationRelativeTo(null);
		mm.setVisible(true);
	}
	
	/*
	 * 	Changes the window to word gui
	 */
	
	public void goWordMenu() {
		WordGUI wg = new WordGUI();
		wg.setLocationRelativeTo(null);
		wg.setVisible(true);
	}
	
	/*
	 * 	Changes the window to game gui
	 */
	
	public void goGameMenu() {
		GameGUI gg = new GameGUI();
		gg.setLocationRelativeTo(null);
		gg.setVisible(true);
	}
	
}
