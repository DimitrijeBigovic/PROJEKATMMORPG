package character;


import jakarta.persistence.*;
import item.item;
import job.job;
import player.player;

import java.util.List;

@Entity
public class character {
@Id
    private  long id;
    private String name;
    private String username;
    private int level;
    @ManyToOne
    private player player;
    @OneToMany
    private List<job> jobs;
    @OneToMany
    private List<item> items;


}
