package qs0va.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.*;

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

    @JsonIgnore
    public Set<PlayerGame> getPlayersGames() {
        return playersGames;
    }
    public void setPlayersGames(Set<PlayerGame> playersGames) {
        this.playersGames = playersGames;
    }

    @JsonProperty
    List<Player> listPlayers() {
        List out = new ArrayList();
        for (Iterator<PlayerGame> i = playersGames.iterator(); i.hasNext();) {
            PlayerGame el = i.next();
            out.add(el.getPlayer());
        }
        return out;
    }

    @Override
    public String toString() {
        String out = "Game{" +
                "id=" + id +
                ", players(";
        try {
            for (Iterator<PlayerGame> i = playersGames.iterator(); i.hasNext();) {
                PlayerGame el = i.next();
                out += el.getPlayerId() + " ";
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        out += ")}";
        return out;
    }
}
