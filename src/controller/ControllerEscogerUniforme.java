package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Team;

public class ControllerEscogerUniforme implements Initializable {

	private ControllerMenu cm;

	@FXML
	private ImageView uniform;
	@FXML
	private Button siguiente;
	@FXML
	private Button previo;
	@FXML
	private Button jugar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cm = new ControllerMenu();
	}

	public void inicial() throws Exception {
		Image image = new Image(new FileInputStream(".\\UniformeColombia.jpg"));
	}

}
