package by.epam.task5004.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Gem extends Treasure implements Serializable {
    private GemType type;
    private double carat;

    public Gem() {
        super();
        this.type = GemType.OTHER;
        this.carat = 0.0;
    }

    public Gem(GemType type, double carat, BigDecimal cost) {
        super(cost);
        this.type = type;
        this.carat = carat;
    }

    public Gem(int id, GemType type, double carat, BigDecimal cost) {
        super(id, cost);
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
        Gem gem = (Gem) o;
        return getId() == gem.getId() &&
                Double.compare(gem.carat, carat) == 0 &&
                type == gem.type &&
                getCost().equals(gem.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), type, carat, getCost());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + getId() +
                ", type=" + type +
                ", carat=" + carat +
                ", cost=" + this.getCost() +
                '}';
    }
}

