package model;


import jakarta.persistence.*;

@Entity
public class Character {
    @Id
    private long id;
    private String name;
    private String surname;
    private int level;

    public Character() {

    }

}
