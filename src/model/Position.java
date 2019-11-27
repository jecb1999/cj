package model;

public class Position {

	private String name;
	private Team team1;
	private Team team2;
	private Position right;
	private Position left;
	private Match match;

	public Position(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
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

}
