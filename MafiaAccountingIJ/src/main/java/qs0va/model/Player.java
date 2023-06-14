package qs0va.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String email;
    @Column(name = "nickname", unique = true)
    String nickname;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    Set<PlayerGame> playersGames;

    public Player(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
    public Player() {

    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonIgnore
    public Set<PlayerGame> getPlayersGames() {
        return playersGames;
    }
    public void setPlayersGames(Set<PlayerGame> playersGames) {
        this.playersGames = playersGames;
    }

    @Override
    public String toString() {
        String out = "Player{ " +
                "id=" + id +
                ", email='" + email +
                "', nickname='" + nickname +
                "', games(";
        try {
            for (Iterator<PlayerGame> i = playersGames.iterator(); i.hasNext();) {
                PlayerGame el = i.next();
                out += el.getGameId() + " ";
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        out += ")}";
        return out;
    }
}
