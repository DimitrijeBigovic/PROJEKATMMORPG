package model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = Player.GET_ALL_PLAYERS, query = "SELECT p from Player p")
public class Player {
    public static final String GET_ALL_PLAYERS = "GetAllPlayers";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1)
    private Long id;
    private String username;
    @Transient
    private List<Character> characterList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Player() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return Objects.equals(username, player.username);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
