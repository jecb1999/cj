package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Match;
import threads.BallonThread;

public class ControllerCancha implements Initializable {

	private static ControllerMenu cm;
	private Match match;
	private BallonThread bt;
	@FXML
	private ImageView jugador;
	@FXML
	private ImageView oponente;
	@FXML
	private ImageView balon;
	@FXML
	private ImageView cancha;
	@FXML
	private Label segundos;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cm = new ControllerMenu();
		 match = cm.getGame().getMatch();
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
			bt = new BallonThread(this, match.getBall());
			bt.start();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void moveBallon() {
		balon.setX(match.getBall().getX());
		balon.setY(match.getBall().getY());
		
	}
	
	
	

}
