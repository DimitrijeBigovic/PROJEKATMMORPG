package player;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class player {
@Id
    private long id;
    private String username;
}
