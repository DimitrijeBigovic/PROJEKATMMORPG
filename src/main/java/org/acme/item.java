package org.acme;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class item {
    @Id
    private long id;
    private String name;


}
