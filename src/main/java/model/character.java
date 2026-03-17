package model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class character {
    @Id
    private long id;
    private String name;
    private String username;
    private int level;


}
