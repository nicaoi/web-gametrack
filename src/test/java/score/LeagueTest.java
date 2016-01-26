package score;

import score.club.model.Club;
import score.club.model.Team;
import score.competition.Fixture;
import score.competition.League;
import score.core.Grade;
import score.player.Player;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * User: ksutton
 * Date Created: 19/01/2016.
 */
public class LeagueTest {

	public void setUp() {

		Player playerOne = new Player("Player", "One");
		playerOne.setGrade(Grade.E);

		Player playerTwo = new Player("Player", "Two");
		playerTwo.setGrade(Grade.E);

		List<Player> players = new ArrayList<>();
		players.add(playerOne);
		players.add(playerTwo);

		Club club = new Club();
		club.setName("Club name");
		club.setMembers(players);

		Team team = new Team();
		team.setClub(club);
		team.setGrade(Grade.E);
		team.setPlayers(players);

		List<Team> teams = new ArrayList<>();
		teams.add(team);

		League league = new League();
		league.setGrade(Grade.E);
		league.setTeams(teams);

		Fixture fixture = new Fixture();
		fixture.setHomeTeam(team);
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2016, 1, 1), LocalTime.of(21, 0, 0));
		fixture.setDateTime(localDateTime);

	}




}
