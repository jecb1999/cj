package model;

public class Score {

	private String name;
	private int Score;
	private Score right;
	private Score left;

	public Score(String name, int score) {
		super();
		this.name = name;
		Score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

}
