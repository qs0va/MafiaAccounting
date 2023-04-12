package qs0va.repositories;

import org.springframework.data.repository.CrudRepository;
import qs0va.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
