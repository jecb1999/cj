package threads;

import controller.ControllerCancha;
import model.Ball;

public class BallonThread extends Thread{
	
	private ControllerCancha cc;
	private Ball b;
	
	public BallonThread(ControllerCancha cc,Ball b) {
		this.cc = cc;
		this.b = b;
	}
	
	public void run() {
		try {
			boolean noEnd = true;
			while(noEnd) {
			sleep(100);
			cc.moveBallon();
			b.mover();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
