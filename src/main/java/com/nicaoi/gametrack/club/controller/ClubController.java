package com.nicaoi.gametrack.club.controller;

import com.nicaoi.gametrack.club.service.VenueRepository;
import com.nicaoi.gametrack.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.nicaoi.gametrack.club.model.Club;
import com.nicaoi.gametrack.club.model.Venue;
import com.nicaoi.gametrack.club.service.ClubRepository;
import com.nicaoi.gametrack.player.PlayerRepository;

import java.util.Collection;

/**
 * User: ksutton
 * Date Created: 20/01/2016.
 */
@RestController
@RequestMapping("/api/club")
public class ClubController {

	private final ClubRepository clubRepository;
	private final VenueRepository venueRepository;
	private final PlayerRepository playerRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Club>> listClubs() {
		return new ResponseEntity<> ((Collection<Club>) this.clubRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Club> getClub(@PathVariable("id") long id) {
		Club c = this.clubRepository.findOne(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> addClub(@RequestBody Club club, UriComponentsBuilder builder) {
		clubRepository.save(club);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/{id}").buildAndExpand(club.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Club> updateClub(@PathVariable("id") long id, @RequestBody Club club) {
		Club c = this.clubRepository.findOne(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		c.setName(club.getName());
		clubRepository.save(c);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Club> deleteClub(@PathVariable("id") long id) {
		Club c = this.clubRepository.findOne(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clubRepository.delete(c);
		return new ResponseEntity<>(c, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}/venue", method = RequestMethod.GET)
	public ResponseEntity<Collection<Venue>> listVenuesOfClub(@PathVariable("id") long id) {
		Club c = this.clubRepository.findOne(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(c.getVenues(), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}/venue/{venueId}", method = RequestMethod.PUT)
	public ResponseEntity<Void> addVenueToClub(@PathVariable("id") long id, @PathVariable("venueId") long venueId) {
		Club c = this.clubRepository.findOne(id);
		Venue v = this.venueRepository.findOne(venueId);
		if (c == null || v == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		c.getVenues().add(v);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value="/{id}/venue/{venueId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removeVenueFromClub(@PathVariable("id") long id, @PathVariable("venueId") long venueId) {
		Club c = this.clubRepository.findOne(id);
		Venue v = this.venueRepository.findOne(venueId);
		if (c == null || v == null || !c.getVenues().contains(v)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		c.getVenues().remove(v);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}/player", method = RequestMethod.GET)
	public ResponseEntity<Collection<Player>> listPlayersOfClub(@PathVariable("id") long id) {
		Club c = this.clubRepository.findOne(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(c.getPlayers(), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}/player/{venueId}", method = RequestMethod.PUT)
	public ResponseEntity<Void> addPlayerToClub(@PathVariable("id") long id, @PathVariable("playerId") long playerId) {
		Club c = this.clubRepository.findOne(id);
		Player p = this.playerRepository.findOne(playerId);
		if (c == null || p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		c.getPlayers().add(p);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value="/{id}/player/{playerId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removePlayerFromClub(@PathVariable("id") long id, @PathVariable("playerId") long playerId) {
		Club c = this.clubRepository.findOne(id);
		Player p = this.playerRepository.findOne(playerId);
		if (c == null || p == null || !c.getPlayers().contains(p)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		c.getPlayers().remove(p);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Autowired
	public ClubController(ClubRepository clubRepository, VenueRepository venueRepository, PlayerRepository playerRepository) {
		this.clubRepository = clubRepository;
		this.venueRepository = venueRepository;
		this.playerRepository = playerRepository;
	}
}