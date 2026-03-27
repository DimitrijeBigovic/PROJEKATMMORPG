package model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQuery(name = GameCharacter.GET_ALL_CHARACTERS_FOR_PLAYER_ID, query = "SELECT gc FROM GameCharacter gc WHERE gc.player.id=:idP")
public class GameCharacter {
    public static final String GET_ALL_CHARACTERS_FOR_PLAYER_ID = "getAllCharactersForPlayerId";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_character_seq")
    @SequenceGenerator(name = "game_character_seq", sequenceName = "game_character_seq", allocationSize = 1)
    private long id;
    private String name;
    private String surname;
    private int level;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    @JsonIgnore
    private Player player;

    public GameCharacter() {
    }

    public GameCharacter( String name, String surname, int level) {

        this.name = name;
        this.surname = surname;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GameCharacter)) {
            return false;
        }
        return Objects.equals(name, ((GameCharacter) obj).name) && Objects.equals(surname, ((GameCharacter) obj).surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Surname: " + surname + ", Level: " + level;
    }
}
