package threads;

import controller.ControllerCancha;
import model.Match;

public class MarcadorThread extends Thread{
	
	private ControllerCancha cc;
	private Match m;
	
	public MarcadorThread (ControllerCancha cc, Match m) {
		this.cc = cc;
		this.m = m;
	}
	
	public void run() {
		try {
			boolean noEnd = true;
			while(noEnd) {
			sleep(300);
			cc.moveMarcador();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
