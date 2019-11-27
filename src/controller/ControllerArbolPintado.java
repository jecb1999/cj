package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import model.Position;

public class ControllerArbolPintado implements Initializable{
	
	private ControllerMenu cm;
	private GraphicsContext gc;
	@FXML
	private Canvas arbolPintado;
	@FXML
	private Button jugar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cm = new ControllerMenu();
		gc = arbolPintado.getGraphicsContext2D();
		dibujarArbol();
		
	}
	
	public void dibujarArbol() {
		pintarNodo(20, 0, cm.getGame().getPosition(),(int) arbolPintado.getWidth());
	}
	
	public void pintarNodo(int h, int w, Position pos, int dim) {
		gc.fillText(pos.getFase(), w+(dim/2), h);
		gc.fillText(pos.getTeam1()+"", w+(dim/2), h+20);
		gc.fillText(pos.getTeam2()+"", w+(dim/2), h+40);
		if(pos.getLeft() != null && pos.getRight() != null) {
			pintarNodo(h+60,w,pos.getLeft(),dim/2);
			pintarNodo(h+60,w+dim/2,pos.getRight(),dim/2);
			
		}
	}
	
	public void clickJugar(ActionEvent ae) {
		cm.getGame().getTeamGanador();
		dibujarArbol();
	}

}