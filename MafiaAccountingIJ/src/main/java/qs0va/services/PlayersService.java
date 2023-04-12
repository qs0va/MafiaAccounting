package qs0va.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import qs0va.model.Player;
import qs0va.repositories.PlayerRepository;

import java.util.*;

@Component
public class PlayersService {

    @Autowired
    PlayerRepository repository;

    public List<Player> getAll() {
        return (List<Player>) repository.findAll();
    }

    public Player getById(int id) {
        return repository.findById(Long.valueOf(id)).get();
    }

    public void add(Player player) {
        repository.save(player);
    }
}
