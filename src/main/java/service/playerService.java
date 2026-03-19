package service;


import exception.PlayerException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Player;

import java.util.List;

@Dependent
public class playerService {

    @Inject
    EntityManager em;

    @Transactional
    public Player createPlayer(Player player) throws PlayerException {
if (player ==null){
    throw new PlayerException("Player is null ");
}
if (player.getUsername()==null){
    throw new PlayerException("Player username is null ");
}
        return em.merge(player);
    }


    public List<Player> getAllPlayers() {
        return em.createNamedQuery(Player.GET_ALL_PLAYERS, Player.class).getResultList();
    }


}
