package by.epam.task5004.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Decoration extends Treasure implements Serializable {
    private DecorationType type;
    private double weight;
    private List<PreciousMetal> metals;
    private List<GemType> gemsTypes;

    public Decoration() {
        super();
        this.type = DecorationType.OTHER;
        this.weight = 0.0;
        this.metals = new ArrayList<>();
        this.gemsTypes = new ArrayList<>();
    }

    public Decoration(DecorationType type, double weight, List<PreciousMetal> metals, BigDecimal cost) {
        super(cost);
        this.type = type;
        this.weight = weight;
        this.metals = new ArrayList<>();
        this.gemsTypes = new ArrayList<>();
    }

    public Decoration(DecorationType type, double weight, List<PreciousMetal> metals, List<GemType> gemsTypes, BigDecimal cost) {
        super(cost);
        this.type = type;
        this.weight = weight;
        this.metals = metals;
        this.gemsTypes = gemsTypes;
    }

    public Decoration(int id, DecorationType type, double weight, List<PreciousMetal> metals, BigDecimal cost) {
        super(id, cost);
        this.type = type;
        this.weight = weight;
        this.metals = new ArrayList<>();
        this.gemsTypes = new ArrayList<>();
    }

    public Decoration(int id, DecorationType type, double weight, List<PreciousMetal> metals,
                      List<GemType> gemsTypes, BigDecimal cost) {
        super(id, cost);
        this.type = type;
        this.weight = weight;
        this.metals = metals;
        this.gemsTypes = gemsTypes;
    }

    public DecorationType getType() {
        return type;
    }

    public void setType(DecorationType type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<PreciousMetal> getMetals() {
        return metals;
    }

    public void setMetals(List<PreciousMetal> metals) {
        this.metals = metals;
    }

    public List<GemType> getGemsTypes() {
        return gemsTypes;
    }

    public void setGemsTypes(List<GemType> gemsTypes) {
        this.gemsTypes = gemsTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Decoration)) return false;
        Decoration that = (Decoration) o;
        return getId()==that.getId() &&
                Double.compare(that.weight, weight) == 0 &&
                type == that.type &&
                Objects.equals(metals, that.metals) &&
                Objects.equals(gemsTypes, that.gemsTypes) &&
                getCost().equals(that.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), type, weight, metals, gemsTypes, getCost());
    }

    @Override
    public String toString() {
        return "Decoration{" +
                "id=" + getId() +
                ", type=" + type +
                ", weight=" + weight +
                ", metals=" + metals.toString() +
                ", gemsTypes=" + gemsTypes.toString() +
                ", cost=" + this.getCost() +
                '}';
    }

    public enum DecorationType {
        CROWN,
        RING,
        NECKLACE,
        BRACELET,
        EARRINGS,
        OTHER
    }
}
