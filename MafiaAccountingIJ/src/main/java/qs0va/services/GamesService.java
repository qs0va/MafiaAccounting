package qs0va.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import qs0va.model.Game;
import qs0va.repositories.GameRepository;

import java.util.List;

@Component
public class GamesService {
    @Autowired
    GameRepository repository;

    public List<Game> getAll() {
        return (List<Game>) repository.findAll();
    }

    public Game getById(int id) {
        return repository.findById(Long.valueOf(id)).get();
    }

    public void add(Game game) {
        repository.save(game);
    }
}
