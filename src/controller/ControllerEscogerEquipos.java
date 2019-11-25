package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Team;

public class ControllerEscogerEquipos implements Initializable {
	
	
	private static ControllerMenu cm;
	@FXML
	private Button anterior;
	@FXML
	private Button empezar;
	@FXML
	private Button siguiente;
	@FXML
	private Label equipo;
	@FXML 
	private ImageView uniform;
	@FXML
	private Button local;
	@FXML
	private Button visitante;
	private Stage stageUniforme;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cm = new ControllerMenu();
		equipo.setText(cm.getGame().getFirstTeam().getName());
		Image image;
		try {
			image = new Image(new FileInputStream(cm.getGame().getFirstTeam().getFirstUniform().getImg()));
			uniform.setImage(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		stageUniforme = new Stage();
	}

	public void clicSiguiente(ActionEvent ae) throws Exception {
		Team actual = cm.getGame().searchTeam(equipo.getText());
		if (actual.getSig() != null) {
			equipo.setText(actual.getSig().getName());
		}
		if (actual.getSig() != null && actual.getSig().getFirstUniform() != null) {
			Image image = new Image(new FileInputStream(actual.getSig().getFirstUniform().getImg()));
			uniform.setImage(image);
		}
	}

	public void clickPrev(ActionEvent ae) throws IOException {
		Team actual = cm.getGame().searchTeam(equipo.getText());
		if (actual.getPrev() != null) {
			equipo.setText(actual.getPrev().getName());
		}
		if (actual.getPrev() != null && actual.getPrev().getFirstUniform() != null) {
			Image image = new Image(new FileInputStream(actual.getPrev().getFirstUniform().getImg()));
			uniform.setImage(image);
		}
	}
	
	public void clickLocal(ActionEvent ae) throws Exception {
		Team actual = cm.getGame().searchTeam(equipo.getText());
		if (actual.getFirstUniform() != null) {
			Image image = new Image(new FileInputStream(actual.getFirstUniform().getImg()));
			uniform.setImage(image);
		}
	}
	
	public void clickVisitante(ActionEvent ae) throws Exception{
		Team actual = cm.getGame().searchTeam(equipo.getText());
		if (actual.getFirstUniform() != null && actual.getFirstUniform().getNext() != null) {
			Image image = new Image(new FileInputStream(actual.getFirstUniform().getNext().getImg()));
			uniform.setImage(image);
		}
	}
}
