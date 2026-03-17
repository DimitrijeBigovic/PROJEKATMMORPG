package service;


import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.player;

import java.util.List;

@Dependent
public class playerService {

    @Inject
    EntityManager em;

    @Transactional
    public player createPlayer(player player) {
        return em.merge(player);
    }

    public List<player> getAllPlayers() {
        return em.createNamedQuery(player.GET_ALL_PLAYERS, player.class).getResultList();
    }


}
