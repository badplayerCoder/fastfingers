package addon;

public class Timer {

	public String updateTimer(int timer) {
		String txtTimer = null;
		int minute = 0;
		int second = timer;

		if(second == 60) {
			minute = 1;
			second = 0;
			txtTimer = minute + ":00";
		}else if(second <= 59) {
			minute = 0;
			txtTimer = minute + ":" + second;
		}
		return txtTimer;
	}
}
	
