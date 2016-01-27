package com.nicaoi.gametrack.club.model;

import com.nicaoi.gametrack.core.Grade;
import com.nicaoi.gametrack.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ksutton
 * Date Created: 19/01/2016.
 */
public class Team {
	private Club club;
	private List<Player> players = new ArrayList<>();
	private Grade grade;

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}
