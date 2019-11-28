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

	public Position getFirstPosition() {
		return firstPosition;
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
			prev1.setFather(pos);
			prev2.setFather(pos);
			anhadirHijos(prev1, nivel + 1);
			anhadirHijos(prev2, nivel + 1);
		} else {
			pos.setFase("octavos");
		}
	}

	public void simularPartido(Position pos) {
		Team ganador = null;

		ganador = pos.resultadoPartidos();
		pos.setTeamGanador(ganador);
		if (pos.getFather() != null) {
			if (pos.getFather().getTeam1() == null) {
				pos.getFather().setTeam1(ganador);
			} else {
				pos.getFather().setTeam2(ganador);
			}
		}

	}

	public boolean isJugable(Position position) {
		boolean ret = false;
		if (position.getTeam1().getName().equals(teamJugador.getName())
				|| position.getTeam2().getName().equals(teamJugador.getName())) {
			ret = true;
		}
		return ret;
	}
	
	

	public Match addMatch(Position pos) {
		Team jugador = null;
		Team oponente = null;
		if (pos.getTeam1().getName().equals(teamJugador.getName())) {
			jugador = pos.getTeam1();
			oponente = pos.getTeam2();
		} else {
			jugador = pos.getTeam2();
			oponente = pos.getTeam1();
		}
		Clock c = new Clock();
		Ball b = new Ball(200, 200, "ball.jpg");
		GameUser gu = new GameUser(20, 20, jugador.getName() + "Local.png");
		Opponent op = new Opponent(20, 20, oponente.getName() + "Local.png");
		Match nuevoM = new Match(c, b, op, gu);
		pos.setMatch(nuevoM);
		return nuevoM;
	}

	public Match getMatch() {
		Match m = null;
		Position pos = firstPosition.posSig();
		while (pos != null && !isJugable(pos)) {
			simularPartido(pos);
			pos = firstPosition.posSig();
		}
		if (pos != null) {
			m = addMatch(pos);
		}
		return m;
	}
}
