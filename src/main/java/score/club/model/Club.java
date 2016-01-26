package score.club.model;

import score.player.Player;

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

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="venue_id")
	private Venue venue;

	@OneToMany(mappedBy = "club")
	private List<Player> members = new ArrayList<>();

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

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public List<Player> getMembers() {
		return members;
	}

	public void setMembers(List<Player> members) {
		this.members = members;
	}
}
