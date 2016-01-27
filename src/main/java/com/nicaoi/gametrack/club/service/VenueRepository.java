package com.nicaoi.gametrack.club.service;

import org.springframework.data.repository.CrudRepository;
import com.nicaoi.gametrack.club.model.Venue;

import java.util.List;

/**
 * User: ksutton
 * Date Created: 26/01/2016.
 */
public interface VenueRepository extends CrudRepository<Venue, Long> {
	List<Venue> findByName(String name);
}
