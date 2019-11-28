package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Match;
import threads.BallonThread;
import threads.ClockThread;
import threads.OpponentThread;

public class ControllerCancha implements Initializable {

	private static ControllerMenu cm;
	private Match match;
	private BallonThread bt;
	private ClockThread ct;
	private OpponentThread op;
	@FXML
	private ImageView jugador;
	@FXML
	private ImageView oponente;
	@FXML
	private ImageView balon;
	@FXML
	private ImageView cancha;
	@FXML
	private Text segundos;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cm = new ControllerMenu();
		match = cm.getGame().getMatch();
		bt = new BallonThread(this, match.getBall());
		bt.start();
		segundos.setText("0");
		ct = new ClockThread(this, match.getClock());
		ct.start();
		op = new OpponentThread(this, match.getOpponent());
		op.start();
		
		try {
			Image image = new Image(new FileInputStream(".\\img\\Cancha.png"));
			cancha.setImage(image);
			Image image1 = new Image(new FileInputStream(match.getGameUser().getImg()));
			jugador.setImage(image1);
			Image image2 = new Image(new FileInputStream(match.getOpponent().getImg()));
			oponente.setImage(image2);
			Image image3 = new Image(new FileInputStream(".\\ball.png"));
			balon.setX(match.getBall().getX());
			balon.setY(match.getBall().getY());
			balon.setImage(image3);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void moveBallon() {
		balon.setX(match.getBall().getX());
		balon.setY(match.getBall().getY());
	}

	public void moveTime() {
		segundos.setText(Integer.toString(match.getClock().getSeconds()));
	}
	
	public void moveOpponent() {
		oponente.setY(match.getOpponent().getY());
	}

}
