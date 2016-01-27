package com.nicaoi.gametrack.club.controller;

import com.nicaoi.gametrack.club.model.Club;
import com.nicaoi.gametrack.club.model.Venue;
import com.nicaoi.gametrack.club.service.ClubRepository;
import com.nicaoi.gametrack.club.service.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;

/**
 * User: ksutton
 * Date Created: 27/01/2016.
 */
@RestController
@RequestMapping("/api/venue")
public class VenueController {

	private final VenueRepository venueRepository;
	private final ClubRepository clubRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Venue>> listVenues() {
		return new ResponseEntity<> ((Collection<Venue>) this.venueRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Venue> getVenue(@PathVariable("id") long id) {
		Venue v = this.venueRepository.findOne(id);
		if (v == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(v, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> addVenue(@RequestBody Venue venue, UriComponentsBuilder builder) {
		venueRepository.save(venue);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/{id}").buildAndExpand(venue.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Venue> updateVenue(@PathVariable("id") long id, @RequestBody Venue venue) {
		Venue v = this.venueRepository.findOne(id);
		if (v == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		v.setName(venue.getName());
		venueRepository.save(v);
		return new ResponseEntity<>(v, HttpStatus.OK);
	}

	@RequestMapping(value="/{id}/club", method = RequestMethod.GET)
	public ResponseEntity<Collection<Club>> listClubsOfVenue(@PathVariable("id") long id) {
		Venue v = this.venueRepository.findOne(id);
		if (v == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(v.getClubs(), HttpStatus.OK);
	}

	@Autowired
	public VenueController(VenueRepository venueRepository, ClubRepository clubRepository) {
		this.venueRepository = venueRepository;
		this.clubRepository = clubRepository;
	}
}
