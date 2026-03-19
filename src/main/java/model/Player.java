package model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = Player.GET_ALL_PLAYERS, query = "SELECT p from Player p")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Player {
    public static final String GET_ALL_PLAYERS = "GetAllPlayers";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1)
    private Long id;
    private String username;
    @Transient
    private List<Character> characterList;


}
