package addon;

public class Placeholder {

	private String phWordText; //Placeholder string to move between classes
	private boolean removed;
	private boolean kept;
	private boolean chosen;
	
	public boolean getKept() {
		return kept;
	}
	
	public boolean getRemoved() {
		return removed;
	}
	
	public boolean getChosen() {
		return chosen;
	}
	
	public String getPHWordText() {
		return phWordText;
	}
	
	public void setPHWordText(String text) {
		phWordText = text;
	}
	
	public void setRemoved(boolean b) {
		removed = b;
	}
	
	public void setKept(boolean k) {
		kept = k;
	}
	
	public void setChosen(boolean c) {
		chosen = c;
	}
}
