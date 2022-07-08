package chapter06;

public class Car1 {
	private int speed;
	private boolean stop;
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if (speed > 0) {
			this.speed = speed;
		}
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}
}