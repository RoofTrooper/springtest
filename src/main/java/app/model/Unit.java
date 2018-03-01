package app.model;

import javax.persistence.*;

@Entity
@Table(name = "UNITS")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long unitType;

    public Unit() {
    }

    public Unit(long unitType) {
        this.unitType = unitType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUnitType() {
        return unitType;
    }

    public void setUnitType(long unitType) {
        this.unitType = unitType;
    }

    @Override
    public String toString() {
        return " ID: " + this.id + " Unit type: " + this.unitType;
    }
}
