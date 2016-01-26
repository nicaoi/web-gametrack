package score.competition;

import score.club.model.Team;
import score.club.model.Venue;

import java.time.LocalDateTime;

/**
 * User: ksutton
 * Date Created: 19/01/2016.
 */
public class Fixture {
	private Team homeTeam;
	private Team awayTeam;
	private LocalDateTime dateTime;
	private Venue venue;

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
}
