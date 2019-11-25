package model;

public class Game {

	private Score firstScore;
	private Tournament tournament;
	private Team firstTeam;

	public Game() {
		start();
	}

	public Team getFirstTeam() {
		return firstTeam;
	}

	public void addTeam(String n) {
		Team newTeam = new Team(n);
		if (firstTeam == null) {
			firstTeam = newTeam;
		} else {
			firstTeam.addTeam(newTeam);
		}
	}

	public Team searchTeam(String name) {
		if (firstTeam != null) {
			if (firstTeam.getName().equals(name)) {
				return firstTeam;
			} else {
				return firstTeam.searchTeam(name);
			}
		} else {
			return null;
		}
	}

	public void addUniform(String nameTeam, String img) {
		Uniform newUniform = new Uniform(img);
		if (searchTeam(nameTeam) != null) {
			searchTeam(nameTeam).addUniform(newUniform);
		}
	}

	public Uniform searchUniform(String nameTeam, String img) {
		if (searchTeam(nameTeam) != null) {
			return searchTeam(nameTeam).searchUniform(img);
		} else
			return null;
	}

	public void start() {
		addTeam("Colombia");
		addTeam("Uruguay");
		addTeam("Mexico");
		addTeam("Argentina");
		addTeam("Ecuador");
		addTeam("Venezuela");
		addTeam("Brazil");
		addTeam("Paraguay");
		addTeam("USA");
		addTeam("Peru");

	}

}
