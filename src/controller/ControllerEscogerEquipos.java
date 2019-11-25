package controller;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Team;

public class ControllerEscogerEquipos implements Initializable {
	
	private static ControllerEscogerUniforme cu;
	private static ControllerMenu cm;
	@FXML
	private Button anterior;
	@FXML
	private Button empezar;
	@FXML
	private Button siguiente;
	@FXML
	private Label equipo;
	private Stage stageUniforme;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cu = new ControllerEscogerUniforme();
		cm = new ControllerMenu();
		equipo.setText(cm.getGame().getFirstTeam().getName());
		stageUniforme = new Stage();
	}

	public void clicSiguiente(ActionEvent ae) {
		Team actual = cm.getGame().searchTeam(equipo.getText());
		if (actual.getSig() != null) {
			equipo.setText(actual.getSig().getName());
		}
	}

	public void clickPrev(ActionEvent ae) {
		Team actual = cm.getGame().searchTeam(equipo.getText());
		if (actual.getPrev() != null) {
			equipo.setText(actual.getPrev().getName());
		}
	}
	
	public void clickUniforme(ActionEvent ae) throws Exception {
		AnchorPane escoger = FXMLLoader.load(getClass().getResource("/application/EscogerUniforme.fxml"));
		Scene scene = new Scene(escoger);
		cm.getStage().close();
		cu.inicial();
		stageUniforme.setScene(scene);
		stageUniforme.show();
	}
}
