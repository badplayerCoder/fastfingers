package database;

import addon.Config;
import controller.WordController;

public class DBWord {

	private WordController wc; //Normally it is wordController, but for faster coding words in database, it will be wc
	private Config cfg; //Same as above
	
	//	Language classes
	private Danish danish;
	private English english;
	
	public DBWord() {
		init();
	}
	
	/**
	 * 	Picks what language to use, by dropDb first then pick language db & setups new DB
	 * 	@param	text	is used to find out what language package is needed
	 * 	@return	s	returns what case has been used in the switch case
	 */
	
	public String pickLang(String text) {
		String s = "";
		dropDB();
		switch(text) {
			case "danish":
				s = "danish";
				danish.danishSetup();
				break;
			case "english":
				s = "english";
				english.englishSetup();
				break;
			case "help":
				s = "help";
				danish.danishSetup();
				break;
			case "info":
				s = "info";
				danish.danishSetup();
				break;
			case "empty":
				s = "empty";
				break;
		}
		
		return s;
	}
	
	/**
	 * 	Use with care! It will empty the wordContainers arrayList in the model layer
	 */
	
	private void dropDB() {
		wc.dropDB();
	}
	
	private void init() {
		wc = new WordController();
		cfg = new Config();
		danish = new Danish();
		english = new English();
	}
	
}
