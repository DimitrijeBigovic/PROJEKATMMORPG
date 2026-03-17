package model;


import jakarta.persistence.*;

@Entity
public class Mount {
    @Id
    private Long id;
    private String name;


    public Mount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
