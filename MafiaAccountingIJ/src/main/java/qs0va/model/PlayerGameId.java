package qs0va.model;

import java.io.Serializable;
import java.util.Objects;

public class PlayerGameId implements Serializable {
    Long playerId;

    Long gameId;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if ( this.getClass() != obj.getClass()) return false;
        PlayerGameId that = (PlayerGameId) obj;
        return Objects.equals(playerId, that.playerId) && Objects.equals(gameId, that.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, gameId);
    }
}