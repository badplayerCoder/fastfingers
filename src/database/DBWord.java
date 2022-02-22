package database;

import addon.Config;
import controller.WordController;

public class DBWord {

	private WordController wc; //Normally it is wordController, but for faster coding words in database, it will be wc
	private Config cfg; //Same as above
	
	public DBWord() {
		init();
		dbDanishSetup();
	}
	
	/*
	 * 	Picks what lang to use, by dropDb first then pick lang db & setups new DB
	 */
	
	public String pickLang(String text) {
		String s = null;
		dropDB();
		switch(text) {
			case "danish":
				s = "danish";
				dbDanishSetup();
				break;
			case "english":
				s = "english";
				dbEnglishSetup();
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
	
	/*
	 * 	DB lang setup 
	 */
	
	private void dbDanishSetup() {
		wc.newWord("skole");
		wc.newWord("blevet");
		wc.newWord("langt");
		wc.newWord("derfor");
		wc.newWord("man");
		wc.newWord("lille");
		wc.newWord("går");
		wc.newWord("tre");
		wc.newWord("hvis");
		wc.newWord("til");
		wc.newWord("os");
		wc.newWord("mod");
		wc.newWord("få");
		wc.newWord("her");
		wc.newWord("over");
		wc.newWord("verden");
		wc.newWord("Danmark");
		wc.newWord("gennem");
		wc.newWord("skulle");
		wc.newWord("andre");
		wc.newWord("af");
		wc.newWord("før");
		wc.newWord("han");
		wc.newWord("sagde");
		wc.newWord("god");
		wc.newWord("nye");
		wc.newWord("igen");
		wc.newWord("blev");
		wc.newWord("jo");
		wc.newWord("børn");
		wc.newWord("hele");
		wc.newWord("frem");
		wc.newWord("sådan");
		wc.newWord("tidligere");
		wc.newWord("eller");
		wc.newWord("da");
		wc.newWord("folk");
		wc.newWord("flere");
		wc.newWord("endnu");
		wc.newWord("første");
		wc.newWord("altid");
		wc.newWord("fået");
		wc.newWord("vores");
		wc.newWord("side");
		wc.newWord("var");
		wc.newWord("med");
		wc.newWord("se");
		wc.newWord("mindre");
		wc.newWord("år");
		wc.newWord("tage");
		wc.newWord("sammen");
		wc.newWord("lige");
		wc.newWord("arbejde");
		wc.newWord("gik");
		wc.newWord("allerede");
		wc.newWord("hende");
		wc.newWord("være");
		wc.newWord("tilbage");
		wc.newWord("fire");
		wc.newWord("par");
		wc.newWord("danske");
		wc.newWord("fra");
	}
	
	private void dbEnglishSetup() {
		
	}
	
	private void init() {
		wc = new WordController();
		cfg = new Config();
	}
	
}
