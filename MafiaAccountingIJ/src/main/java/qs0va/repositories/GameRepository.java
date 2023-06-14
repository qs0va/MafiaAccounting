package qs0va.repositories;

import org.springframework.data.repository.CrudRepository;
import qs0va.model.Game;

public interface GameRepository extends CrudRepository<Game, Long> {
}
