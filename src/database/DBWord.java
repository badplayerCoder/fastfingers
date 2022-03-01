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
		//pickLang("danish"); // Commented out to make selv adding words to work again
	}
	
	/*
	 * 	Picks what lang to use, by dropDb first then pick lang db & setups new DB
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
		}
		
		return s;
	}
	
	/*
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
