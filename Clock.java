import java.util.Random;

public class Clock {
	protected int time;
	
	public Clock() {
		// TODO Auto-generated constructor stub
		Random rand = new Random();
		int start = 5 * rand.nextInt(480);
		//time = start;
		time = 1100;
	}
	
	public int getTime() {
		return time;
	}

	public void addTime(int reps) {
		time = time + (5 * reps);
	}
	
}
