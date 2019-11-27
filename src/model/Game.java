package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Game {

	private Score firstScore;
	private Tournament tournament;
	private Team firstTeam;
	private ArrayList<Team> listaSorteo;

	public Game() {
		start();
		organizarEquipos();

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

	public void organizarEquipos() {
		if (firstTeam != null) {
			Team act = firstTeam;
			while (act != null) {
				Team sig = act.getSig();
				Team menor = act;
				while (sig != null) {
					if (sig.getName().compareTo(menor.getName()) <= 0) {
						menor = sig;
					}
					sig = sig.getSig();
				}
				if (act.getPrev() != null) {
					act.getPrev().setSig(menor);
				} else {
					firstTeam = menor;
				}
				if (menor.getSig() != null) {
					menor.getSig().setPrev(act);
				}
				if (act.getSig() != null && menor == act.getSig()) {
					menor.setPrev(act.getPrev());
					act.setSig(menor.getSig());
					menor.setSig(act);
					act.setPrev(menor);

				} else {
					if (!menor.getName().equals(act.getName())) {

						if (menor.getPrev() != null) {
							menor.getPrev().setSig(act);
						}
						if (act.getSig() != null) {
							act.getSig().setPrev(menor);
						}

						Team temp = menor.getSig();

						menor.setSig(act.getSig());
						act.setSig(temp);
						Team temp2 = menor.getPrev();
						menor.setPrev(act.getPrev());
						act.setPrev(temp2);
					}

				}
				act = menor.getSig();
			}

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
		addTeam("España");
		addTeam("Alemania");
		addTeam("Cuba");
		addTeam("Jamaica");
		addTeam("Canada");
		addTeam("Panama");
		addUniform("Colombia", ".\\UniformeColombia.png");
		addUniform("Colombia", ".\\UniformeColombiaV.jpg");
		addUniform("Uruguay", ".\\UniformeUruguay.jpg");
		addUniform("Uruguay", ".\\UniformeUruguayV.jpg");
		addUniform("Mexico", ".\\UniformeMexico.jpg");
		addUniform("Mexico", ".\\UniformeMexicoV.jpg");
		addUniform("Argentina", ".\\UniformeArgentina.jpg");
		addUniform("Argentina", ".\\UniformeArgentinaV.jpg");
		addUniform("Ecuador", ".\\UniformeEcuador.jpg");
		addUniform("Ecuador", ".\\UniformeEcuadorV.jpg");
		addUniform("Venezuela", ".\\UniformeVenezuela.jpg");
		addUniform("Venezuela", ".\\UniformeVenezuelaV.jpg");
		addUniform("Brazil", ".\\UniformeBrazil.jpg");
		addUniform("Brazil", ".\\UniformeBrazilV.jpg");
		addUniform("Paraguay", ".\\UniformeParaguay.jpg");
		addUniform("Paraguay", ".\\UniformeParaguayV.jpg");
		addUniform("USA", ".\\UniformeUSA.jpg");
		addUniform("USA", ".\\UniformeUSAV.jpg");
		addUniform("Peru", ".\\UniformePeru.jpg");
		addUniform("Peru", ".\\UniformePeruV.jpg");
		addUniform("España", ".\\UniformeEspaña.jpg");
		addUniform("España", ".\\UniformeEspañaV.jpg");
		addUniform("Alemania", ".\\UniformeAlemania.jpg");
		addUniform("Alemania", ".\\UniformeAlemaniaV.jpg");
		addUniform("Panama", ".\\UniformePanama.jpg");
		addUniform("Panama", ".\\UniformePanamaV.jpg");
		addUniform("Cuba", ".\\UniformeCuba.jpg");
		addUniform("Cuba", ".\\UniformeCubaV.jpg");
		addUniform("Jamaica", ".\\UniformeJamaica.jpg");
		addUniform("Jamaica", ".\\UniformeJamaicaV.jpg");
		addUniform("Canada", ".\\UniformeCanada.jpg");
		addUniform("Canada", ".\\UniformeCanadaV.jpg");

	}

	public void serializableLastTournament() {
		try {
			FileOutputStream fs = new FileOutputStream(".\\LastTournament");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(tournament);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readLastTournament() {
		try {

			File f = new File(".\\" + "Serializable");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			tournament = (Tournament) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Team> hacerListaTeam() {
		ArrayList<Team> lt = new ArrayList<Team>();
		Team sig = firstTeam;
		while (sig != null) {
			lt.add(sig);
			sig = sig.getSig();
		}
		return lt;
	}

	public ArrayList<Team> getListaSorteo() {
		return listaSorteo;
	}

	public void addPosition(Team team1, Team team2) {
		tournament.addPosition(team1, team2);
	}

	public void makeTournament() {
		ArrayList<Integer> selected = new ArrayList<Integer>();
		int max = listaSorteo.size() - 1;
		int counter = 0;
		while (counter < 8) {
			int team1 = (int) (Math.random() * max) + 1;
			int team2 = (int) (Math.random() * max) + 1;
			if (team1 == team2) {
				while (team1 == team2) {
					team2 = (int) (Math.random() * max) + 1;
				}
			}
			for (int i = 0; i < selected.size(); i++) {
				if (selected.get(i) == team1) {
					while (selected.get(i) == team1) {
						team1 = (int) (Math.random() * max) + 1;
					}
				}
				if (selected.get(i) == team2 || team1 == team2) {
					while (selected.get(i) == team2) {
						team2 = (int) (Math.random() * max) + 1;
					}
				}
			}
			addPosition(listaSorteo.get(team1), listaSorteo.get(team2));
			selected.add(team1);
			selected.add(team2);
			counter++;
		}
	}

	public void addTeamJugador(Team team) {
		tournament = new Tournament(team);
		listaSorteo = hacerListaTeam();
		makeTournament();
	}
}
