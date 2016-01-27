package com.nicaoi.gametrack.player;

import com.nicaoi.gametrack.club.model.Club;
import com.nicaoi.gametrack.core.Grade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * User: ksutton
 * Date Created: 19/01/2016.
 */
@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	private String lastName;

	private String email;
	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(columnDefinition = "DATETIME")
	private LocalDate dateOfBirth;

	@Enumerated(EnumType.STRING)
	private Grade grade;

	@ManyToMany(mappedBy="players")
	private List<Club> clubs;

	public Player() { }

	public Player(String first_name, String last_name) {
		this.firstName = first_name;
		this.lastName = last_name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}

	@Override
	public String toString() {
		return "Player{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", gender=" + gender +
				", dateOfBirth=" + dateOfBirth +
				", grade=" + grade +
				'}';
	}
}
