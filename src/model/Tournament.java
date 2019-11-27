package model;

import java.io.Serializable;

public class Tournament implements Serializable {

	private Position firstPosition;
	private Team teamJugador;

	public Tournament(Team teamJugador) {
		firstPosition = new Position();
		this.teamJugador = teamJugador;
		anhadirHijos(firstPosition, 0);
	}

	public void addPosition(Team team1, Team team2) {
		firstPosition.addPosition(team1, team2);

	}

	public void setTeamJugador(Team team) {
		teamJugador = team;
	}

	public void anhadirHijos(Position pos, int nivel) {
		if (nivel < 3) {
			Position prev1 = new Position();
			Position prev2 = new Position();
			if (nivel == 0) {
				pos.setFase("final");
			} else if (nivel == 1) {
				pos.setFase("semifinal");
			} else if (nivel == 2) {
				pos.setFase("cuartos de final");
			}
			pos.setRight(prev1);
			pos.setLeft(prev2);
			anhadirHijos(prev1, nivel + 1);
			anhadirHijos(prev2, nivel + 1);
		} else {
			pos.setFase("octavos");
		}
	}
	
	public Position posSig() {
		return firstPosition.posSig();
	}

//	public Team resultadosPartidos() {
//		Team ganador = null;
//		if (!firstPosition.getTeam1().getName().equals(teamJugador.getName())
//				|| !firstPosition.getTeam2().getName().equals(teamJugador.getName())) {
//			ganador = firstPosition.resultadoPartidos();
//		}else {
//			
//		}
//		return ganador;
//	}

}
