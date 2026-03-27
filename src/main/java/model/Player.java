package model;


import jakarta.persistence.*;


import java.util.List;

@Entity
@NamedQuery(name = Player.GET_ALL_PLAYERS, query = "SELECT p from Player p")
@NamedQuery(name = Player.GET_PLAYER_BY_USERNAME, query = "SELECT p from Player p where p.username=:usernameP")

public class Player {
    public static final String GET_ALL_PLAYERS = "GetAllPlayers";
    public static final String GET_PLAYER_BY_USERNAME = "GetPlayerByUsername";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1)
    private Long id;
    private String username;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private List<GameCharacter> Characters;

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

    public List<GameCharacter> getCharacters() {
        return Characters;
    }

    public void setCharacters(List<GameCharacter> gameCharacterList) {
        this.Characters = gameCharacterList;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", Characters=" + Characters +
                '}';
    }
}
