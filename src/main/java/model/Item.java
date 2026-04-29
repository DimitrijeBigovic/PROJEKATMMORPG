package model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = Item.GET_ALL_ITEMS, query = "Select i from Item i")
public class Item {

    public static final String GET_ALL_ITEMS = "getAllItems";
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 1)
    @Id
    private long id;
    private String name;
    private String type;
    private String effect;
    private int quantity;
    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    private List<GameCharacter> characters = new ArrayList<>();


    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }


    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<GameCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(List<GameCharacter> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}

