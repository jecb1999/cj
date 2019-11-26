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

public class ControllerCancha implements Initializable {

	private static ControllerMenu cm;
	@FXML
	private ImageView cancha;
	@FXML
	private Label segundos;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cm = new ControllerMenu();
		try {
			Image image = new Image(new FileInputStream(".\\Cancha.png"));
			cancha.setImage(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
