/**
 * 
 */
package gui;

import javax.swing.JFrame;

import dialog.ExistDialog;
import dialog.MainMenuDialog;
import dialog.ResultDialog;

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
	
	public void goMainMenuDialog() {
		MainMenuDialog mmd = new MainMenuDialog();
		mmd.setLocationRelativeTo(null);
		mmd.setVisible(true);
	}
	
	public void goExistDialog(String text) {
		ExistDialog ed = new ExistDialog(text);
		ed.setLocationRelativeTo(null);
		ed.setVisible(true);
	}
	
	public void goResultDialog(int wpm, double accuracy, int right, int wrong) {
		ResultDialog rd = new ResultDialog(wpm, accuracy, right, wrong);
		rd.setLocationRelativeTo(null);
		rd.setVisible(true);
	}
	
}
