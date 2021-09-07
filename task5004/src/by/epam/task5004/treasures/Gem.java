package by.epam.task5004.treasures;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Gem extends Treasure implements Serializable {
    private GemType type;
    private double carat;

    public Gem() {
        this.type = GemType.OTHER;
        this.carat = 0.0;
    }

    public Gem(GemType type, double carat, BigDecimal cost) {
        super(cost);
        this.type = type;
        this.carat = carat;
    }

    public GemType getType() {
        return type;
    }

    public void setType(GemType type) {
        this.type = type;
    }

    public double getCarat() {
        return carat;
    }

    public void setCarat(double carat) {
        this.carat = carat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gem)) return false;
        if (!super.equals(o)) return false;
        Gem gem = (Gem) o;
        return Double.compare(gem.carat, carat) == 0 &&
                type == gem.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, carat);
    }

    @Override
    public String toString() {
        return "Gem{" +
                "type=" + type +
                ", carat=" + carat +
                ", cost=" + this.getCost() +
                '}';
    }
}

