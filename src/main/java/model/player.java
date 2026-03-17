package model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQuery(name = player.GET_ALL_PLAYERS, query = "SELECT p from player p")
public class player {
    public static final String GET_ALL_PLAYERS = "GetAllPlayers";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1)
    private Long id;
    private String username;
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        player player = (player) obj;
        return Objects.equals(id, player.id);

    }
}
