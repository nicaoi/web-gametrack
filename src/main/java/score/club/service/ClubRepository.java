package score.club.service;

import org.springframework.data.repository.CrudRepository;
import score.club.model.Club;

import java.util.List;

/**
 * User: ksutton
 * Date Created: 20/01/2016.
 */
public interface ClubRepository extends CrudRepository<Club, Long> {
	List<Club> findByName(String name);
}
