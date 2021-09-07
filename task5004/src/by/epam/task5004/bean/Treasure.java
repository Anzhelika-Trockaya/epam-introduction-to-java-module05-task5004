package by.epam.task5004.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Treasure implements Serializable {
    private BigDecimal cost;

    public Treasure() {
        this.cost = BigDecimal.ZERO;
    }

    public Treasure(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Treasure)) return false;
        Treasure treasure = (Treasure) o;
        return Objects.equals(cost, treasure.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost);
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "cost=" + cost +
                '}';
    }
}
