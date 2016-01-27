package com.nicaoi.gametrack.club.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nicaoi.gametrack.player.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: ksutton
 * Date Created: 19/01/2016.
 */
@Entity
@Table(name = "club")
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="club_venue",
			joinColumns={@JoinColumn(name="club_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name="venue_id", referencedColumnName = "id")})
	private List<Venue> venues;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="club_player",
			joinColumns={@JoinColumn(name="club_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name="player_id", referencedColumnName = "id")})
	private List<Player> players = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Venue> getVenues() {
		return venues;
	}

	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
