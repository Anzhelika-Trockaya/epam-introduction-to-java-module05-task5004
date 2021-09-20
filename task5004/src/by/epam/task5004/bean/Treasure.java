package by.epam.task5004.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Treasure implements Serializable {
    private int id;
    private BigDecimal cost;

    public Treasure() {
        this.id = 0;
        this.cost = BigDecimal.ZERO;
    }

    public Treasure(BigDecimal cost) {
        this.id = 0;
        this.cost = cost;
    }

    public Treasure(int id, BigDecimal cost) {
        this.id = id;
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
