package score.competition;

import score.club.model.Team;
import score.core.Grade;

import java.util.List;

/**
 * User: ksutton
 * Date Created: 19/01/2016.
 */
public class League {
	private Grade grade;
	private List<Team> teams;
	private List<Fixture> fixtures;

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Fixture> getFixtures() {
		return fixtures;
	}

	public void setFixtures(List<Fixture> fixtures) {
		this.fixtures = fixtures;
	}
}
