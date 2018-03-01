package app.model;

import javax.persistence.*;

@Entity
@Table(name = "UNITTYPES")
public class UnitType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long superior;

    private long subordinate;

    protected UnitType(){}

    public UnitType(String name, long superior, long subordinate) {
        this.name = name;
        this.superior = superior;
        this.subordinate = subordinate;
    }

    public UnitType(String name) {
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

    public long getSuperior() {
        return superior;
    }

    public void setSuperior(long superior) {
        this.superior = superior;
    }

    public long getSubordinate() {
        return subordinate;
    }

    public void setSubordinate(long subordinate) {
        this.subordinate = subordinate;
    }

    @Override
    public String toString() {
        return " ID: " + this.id + " Name: " + this.name + " Superior: " + this.superior + " Subordinate: " + this.subordinate;
    }
}
