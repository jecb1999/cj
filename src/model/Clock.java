package model;

public class Clock {

	private int minute;
	private int seconds;

	public Clock(int minute, int seconds) {
		this.minute = minute;
		this.seconds = seconds;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}
