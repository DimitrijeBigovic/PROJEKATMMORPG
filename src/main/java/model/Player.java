package model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = Player.GET_ALL_PLAYERS, query = "SELECT p from Player p")
@NamedQuery(name = Player.GET_PLAYER_BY_USERNAME, query = "SELECT p from Player p where p.username=:usernameP")
@NamedQuery(name = Player.GET_PLAYER_BY_ID, query = "SELECT p from Player p WHERE p.id=:id")
public class Player {
    public static final String GET_ALL_PLAYERS = "GetAllPlayers";
    public static final String GET_PLAYER_BY_USERNAME = "GetPlayerByUsername";
    public static final String GET_PLAYER_BY_ID = "GetPlayerByID";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1)
    private Long id;
    private String username;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private List<GameCharacter> Characters;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "player")
    List<TimeZone> timeZones= new ArrayList<TimeZone>();

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

    public List<TimeZone> getTimeZones() {
        return timeZones;
    }

    public void setTimeZones(List<TimeZone> timeZones) {
        this.timeZones = timeZones;
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
