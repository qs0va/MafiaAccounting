package qs0va.model;

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
    Set<PlayerGame> playerGames;

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
}
