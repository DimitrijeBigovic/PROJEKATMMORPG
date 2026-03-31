package service;


import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import model.Item;
import model.Player;

import java.util.List;

@Dependent
public class itemService {

    @Inject
    EntityManager em;

    @Transactional
    public Item addItem(Item item) {
        if (item == null) {
            return null;
        }
        return em.merge(item);
    }

    public List<Item> getAllItems() {

        List<Item> items = em.createNamedQuery(Item.GET_ALL_ITEMS, Item.class).getResultList();
        return items;
    }


}
