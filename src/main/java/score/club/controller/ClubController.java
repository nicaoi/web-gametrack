package score.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import score.club.model.Club;
import score.club.service.ClubRepository;

import java.util.Collection;

/**
 * User: ksutton
 * Date Created: 20/01/2016.
 */
@RestController
@RequestMapping("/api/club")
public class ClubController {

	private final ClubRepository clubRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Club> listAllClubs() {
		return (Collection<Club>) this.clubRepository.findAll();
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
		c.setVenue(club.getVenue());
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

	@Autowired
	public ClubController(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}
}