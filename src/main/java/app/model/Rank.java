package app.model;

import javax.persistence.*;

@Entity
@Table(name = "RANKS")
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Rank() {
    }

    public Rank(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " ID: " + this.id + " Name: " + this.name;
    }
}
