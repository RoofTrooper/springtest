package app.model;

import javax.persistence.*;


@Entity
@Table(name = "PERSONS")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long rank;

    private long post;

    private long unit;

    protected Person() {}

    public Person(String name, long rank, long post, long unit) {
        this.name = name;
        this.rank = rank;
        this.post = post;
        this.unit = unit;
    }

    public Person(String name, long rank, long post) {
        this.name = name;
        this.rank = rank;
        this.post = post;
    }

    public Person(String name) {
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

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public long getPost() {
        return post;
    }

    public void setPost(long post) {
        this.post = post;
    }

    public long getUnit() {
        return unit;
    }

    public void setUnit(long unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return " ID: " + this.id + " Name: " + this.name + " Rank: " + this.rank + " Post: " + this.post + " Unit: " + this.unit;
    }
}
