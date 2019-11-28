package model;

public class Match {

	private Clock clock;
	private Ball ball;
	private Opponent opponent;
	private GameUser gameUser;
	private int golesTeam1;
	private int golesTeam2;

	public Match(Clock clock, Ball ball, Opponent opponent, GameUser gameUser) {
		super();
		this.clock = clock;
		this.ball = ball;
		this.opponent = opponent;
		this.gameUser = gameUser;
		golesTeam1 = 0;
		golesTeam2 = 0;
	}

	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Opponent getOpponent() {
		return opponent;
	}

	public void setOpponent(Opponent opponent) {
		this.opponent = opponent;
	}

	public GameUser getGameUser() {
		return gameUser;
	}

	public void setGameUser(GameUser gameUser) {
		this.gameUser = gameUser;
	}

}
