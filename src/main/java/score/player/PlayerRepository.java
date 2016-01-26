package score.player;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User: ksutton
 * Date Created: 19/01/2016.
 */
public interface PlayerRepository extends CrudRepository<Player, Long> {
	List<Player> findByLastName(String lastName);
}
