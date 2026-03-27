package service;


import exception.PlayerException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.GameCharacter;
import model.Player;

import java.util.List;

@Dependent
public class playerService {

    @Inject
    EntityManager em;

    @Transactional
    public Player createPlayer(Player player) throws PlayerException {
        if (player == null) {
            throw new PlayerException("Player is null ");
        }
        if (player.getUsername() == null) {
            throw new PlayerException("Player username is null ");
        }
        return em.merge(player);
    }


    public List<Player> getAllPlayers() {
        return em.createNamedQuery(Player.GET_ALL_PLAYERS, Player.class).getResultList();
    }


    public List<Player> getAllPlayersByUsername(String username) {
        List<Player> players = em.createNamedQuery(Player.GET_PLAYER_BY_USERNAME, Player.class).setParameter("usernameP", username).getResultList();
        return players;
    }

    public List<GameCharacter> getCharactersByPlayerId(Long id) {

        List<GameCharacter> characters = em.createNamedQuery(GameCharacter.GET_ALL_CHARACTERS_FOR_PLAYER_ID, GameCharacter.class).setParameter("idP", id).getResultList();
        return characters;
    }
}
