package qs0va.services;

import org.springframework.stereotype.Component;
import qs0va.model.Player;

import java.util.*;

@Component
public class PlayersService {

    List<Player> list = new ArrayList<Player>();

    PlayersService() {
        list.add(new Player(1, "email1", "nickname1"));
        list.add(new Player(2, "email2", "nickname2"));
        list.add(new Player(3, "email3", "nickname3"));
    }
    public List<Player> getAll() {
        return list;
    }

    public Player getById(int id) {
        for (Iterator i = list.iterator(); i.hasNext();) {
            Player el = (Player) i.next();
            if (el.getId() == id) {
                return el;
            }
        }
        throw new NoSuchElementException();
    }

    public void add(Player player) {
        list.add(player);
    }
}
