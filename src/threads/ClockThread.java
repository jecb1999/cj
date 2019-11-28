package threads;

import controller.ControllerCancha;
import model.Clock;

public class ClockThread extends Thread {

	private ControllerCancha cc;
	private Clock c;

	public ClockThread(ControllerCancha cc, Clock c) {
		this.cc = cc;
		this.c = c;
	}

	public void run() {
		try {
			boolean noEnd = true;
			while (noEnd) {
				sleep(1000);
				c.time();
				cc.moveTime();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
