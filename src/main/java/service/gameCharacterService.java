package service;


import exception.GameCharacterException;
import exception.PlayerException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import model.GameCharacter;
import model.Item;

import java.util.ArrayList;
import java.util.List;

@Dependent
public class gameCharacterService {

    @Inject
    EntityManager em;
    @Transactional
    public GameCharacter addGameCharacter(GameCharacter character) throws GameCharacterException {
        if (character == null) {
            throw new GameCharacterException("Character is null ");
        }
        if (character.getName() == null) {
            throw new GameCharacterException("Character name is null ");
        }
        if (character.getSurname() == null) {
            throw new GameCharacterException("Character surname is null ");
        }
        if (character.getPlayer().getId() == null) {
            throw new GameCharacterException("Character player is null ");
        }
        if (character.getPlayer() == null) {
            throw new GameCharacterException("Character playerWHOLE is null ");
        }
        return em.merge(character);

    }


    public List<GameCharacter> getCharactersByPlayerId(Long id) {

        List<GameCharacter> characters = em.createNamedQuery(GameCharacter.GET_ALL_CHARACTERS_FOR_PLAYER_ID, GameCharacter.class).setParameter("idP", id).getResultList();
        return characters;
    }

@Transactional
    public GameCharacter addItemToGameCharacter(Long gameCharacter_id, Long item_id) throws GameCharacterException {
        GameCharacter character = em.find(GameCharacter.class, gameCharacter_id);

        if (character == null) {
            throw new GameCharacterException("Character is null ");
        }
        Item item = em.find(Item.class, item_id);
        if (item == null) {
            throw new GameCharacterException("Item is null ");
        }
        if (character.getItems() == null) {
            character.setItems(new ArrayList<>());
        }

if (!character.getItems().contains(item)) {
    character.getItems().add(item);
}
return em.merge(character);



    }
}
