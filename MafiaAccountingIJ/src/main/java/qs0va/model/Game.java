package qs0va.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    Set<PlayerGame> playersGames;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Set<PlayerGame> getPlayersGames() {
        return playersGames;
    }
    public void setPlayersGames(Set<PlayerGame> playersGames) {
        this.playersGames = playersGames;
    }

    @Override
    public String toString() {
        String out = "Game{" +
                "id=" + id +
                ", players(";
        try {
            for (Iterator<PlayerGame> i = playersGames.iterator(); i.hasNext();) {
                PlayerGame el = i.next();
                out += el.getPlayer().getId() + " ";
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        out += ")}";
        return out;
    }
}
