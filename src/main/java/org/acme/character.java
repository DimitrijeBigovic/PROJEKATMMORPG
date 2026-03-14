package org.acme;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class character {
    @Id
    private  long id;
    private String name;
    private String username;
    private int level;
    private player plaer;
    private List<job> jobs;
    private List<item> items;
}
