package qs0va.model;

import jakarta.persistence.*;

@Entity
@IdClass(PlayerGameId.class)
public class PlayerGame {
    @Id
    Long playerId;
    @Id
    Long gameId;

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "playerId")
    Player player;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "gameId")
    Game game;

    double score;

    int slot;

    public PlayerGame() { }
    public PlayerGame(Player player, Game game, int slot, double score) {
        this.player = player;
        this.game = game;
        this.slot = slot;
        this.score = score;
        this.playerId = player.getId();
        this.gameId = game.getId();
    }

    public Long getPlayerId() {
        return playerId;
    }
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getGameId() {
        return gameId;
    }
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }

    public int getSlot() {
        return slot;
    }
    public void setSlot(int slot) {
        this.slot = slot;
    }

    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
}
