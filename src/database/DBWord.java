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
		String s = "";
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
			case "help":
				s = "help";
				dbDanishSetup();
				break;
			case "info":
				s = "info";
				dbDanishSetup();
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
		wc.newWord("side");
		wc.newWord("while");
		wc.newWord("do");
		wc.newWord("when");
		wc.newWord("then");
		wc.newWord("here");
		wc.newWord("show");
		wc.newWord("Indian");
		wc.newWord("mountain");
		wc.newWord("as");
		wc.newWord("school");
		wc.newWord("set");
		wc.newWord("such");
		wc.newWord("in");
		wc.newWord("being");
		wc.newWord("father");
		wc.newWord("next");
		wc.newWord("saw");
		wc.newWord("next");
		wc.newWord("which");
		wc.newWord("he");
		wc.newWord("on");
		wc.newWord("keep");
		wc.newWord("three");
		wc.newWord("answer");
		wc.newWord("below");
		wc.newWord("under");
		wc.newWord("say");
		wc.newWord("your");
		wc.newWord("family");
		wc.newWord("write");
		wc.newWord("feet");
		wc.newWord("add");
		wc.newWord("good");
		wc.newWord("read");
		wc.newWord("what");
		wc.newWord("day");
		wc.newWord("only");
		wc.newWord("enough");
		wc.newWord("go");
		wc.newWord("great");
		wc.newWord("had");
		wc.newWord("why");
		wc.newWord("help");
		wc.newWord("found");
		wc.newWord("off");
		wc.newWord("if");
		wc.newWord("put");
		wc.newWord("came");
		wc.newWord("boy");
		wc.newWord("animal");
		wc.newWord("time");
		wc.newWord("four");
		wc.newWord("first");
		wc.newWord("hear");
		wc.newWord("carry");
		wc.newWord("paper");
		wc.newWord("different");
		wc.newWord("and");
		wc.newWord("want");
		wc.newWord("country");
		wc.newWord("made");
		wc.newWord("often");
		wc.newWord("being");
		wc.newWord("river");
		wc.newWord("walk");
		wc.newWord("mean");
		wc.newWord("way");
		wc.newWord("around");
		wc.newWord("while");
		wc.newWord("city");
		wc.newWord("well");
		wc.newWord("people");
		wc.newWord("watch");
		wc.newWord("miss");
		wc.newWord("very");
		wc.newWord("but");
		wc.newWord("place");
		wc.newWord("always");
		wc.newWord("along");
		wc.newWord("another");
		wc.newWord("new");
		wc.newWord("America");
		wc.newWord("live");
		wc.newWord("sometimes");
		wc.newWord("quickly");
		wc.newWord("line");
		wc.newWord("down");
		wc.newWord("quite");
		wc.newWord("three");
		wc.newWord("picture");
		wc.newWord("began");
		wc.newWord("plant");
		wc.newWord("has");
		wc.newWord("every");
		wc.newWord("state");
		wc.newWord("add");
		wc.newWord("together");
		wc.newWord("last");
		wc.newWord("book");
		wc.newWord("learn");
		wc.newWord("study");
		wc.newWord("two");
		wc.newWord("name");
		wc.newWord("young");
		wc.newWord("now");
		wc.newWord("because");
		wc.newWord("would");
		wc.newWord("food");
		wc.newWord("large");
		wc.newWord("saw");
		wc.newWord("just");
		wc.newWord("eye");
		wc.newWord("us");
		wc.newWord("spell");
		wc.newWord("form");
	}
	
	private void init() {
		wc = new WordController();
		cfg = new Config();
	}
	
}
