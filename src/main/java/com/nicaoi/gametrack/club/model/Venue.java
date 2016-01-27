package com.nicaoi.gametrack.club.model;

import javax.persistence.*;
import java.util.List;

/**
 * User: ksutton
 * Date Created: 19/01/2016.
 */
@Entity
@Table(name = "venue")
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private float longitude;
	private float latitude;

	@ManyToMany(mappedBy="venues")
	private List<Club> clubs;

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

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}
}
