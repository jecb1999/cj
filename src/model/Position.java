package model;

public class Position {

	private String name;
	private Team team1;
	private Team team2;
	private Team teamGanador;
	private Position father;
	private Position right;
	private Position left;
	private Match match;
	private String fase;

	public Position(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
	}

	public Position() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Position getRight() {
		return right;
	}

	public void setRight(Position right) {
		this.right = right;
	}

	public Position getLeft() {
		return left;
	}

	public void setLeft(Position left) {
		this.left = left;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public Team getTeamGanador() {
		return teamGanador;
	}

	public void setTeamGanador(Team teamGanador) {
		this.teamGanador = teamGanador;
		if (getFather() != null) {
			if (getFather().getTeam1() == null) {
				getFather().setTeam1(teamGanador);
			} else {
				getFather().setTeam2(teamGanador);
			}
		}
	}

	public boolean addPosition(Team team1, Team team2) {

		boolean add = false;
		if (left == null && right == null) {
			if (this.team1 == null && this.team2 == null) {
				
				setTeam1(team1);
				setTeam2(team2);
				add = true;
			}
		} else {
			if (left.addPosition(team1, team2)) {
				add = true;
			} else {
				add = right.addPosition(team1, team2);
			}
		}

		return add;
	}

	public Team resultadoPartidos() {
		Team ganador = null;
		int numGanador = (int) (Math.random() * 2) + 1;
		if (numGanador == 1) {
			ganador = team1;
		} else {
			ganador = team2;
		}
		return ganador;
	}

	public Position posSig() {
		Position ret = null;
		if (left == null && right == null) {
			if (teamGanador == null) {
				ret = this;
			}
		} else {
			if (left.getTeamGanador() != null && right.getTeamGanador() != null && teamGanador == null) {
				ret = this;

			} else {
				ret = left.posSig();
				if (ret == null) {
					ret = right.posSig();
				} 
			}
		}
		return ret;
	}

	public Position getFather() {
		return father;
	}

	public void setFather(Position father) {
		this.father = father;
	}

//	public GameUser getGameUser() {
//		
//	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}
