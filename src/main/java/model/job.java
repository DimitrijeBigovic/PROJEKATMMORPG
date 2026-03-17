package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class job {
@Id
    private long id;
    private String name;

}
