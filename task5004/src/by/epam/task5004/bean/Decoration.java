package by.epam.task5004.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class Decoration extends Treasure implements Serializable {
    private DecorationType type;
    private double weight;
    private PreciousMetal[] metals;
    private GemType[] gemsTypes;

    public Decoration(){
        this.type = DecorationType.OTHER;
        this.weight = 0.0;
        this.metals = null;
        this.gemsTypes=null;
    }

    public Decoration(DecorationType type, double weight, PreciousMetal[] metals, BigDecimal cost) {
        super(cost);
        this.type = type;
        this.weight = weight;
        this.metals = null;
        this.gemsTypes=null;
    }

    public Decoration(DecorationType type, double weight, PreciousMetal[] metals, GemType[] gemsTypes, BigDecimal cost) {
        super(cost);
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

    public PreciousMetal[] getMetals() {
        return metals;
    }

    public void setMetals(PreciousMetal[] metals) {
        this.metals = metals;
    }

    public GemType[] getGemsTypes() {
        return gemsTypes;
    }

    public void setGemsTypes(GemType[] gemsTypes) {
        this.gemsTypes = gemsTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Decoration)) return false;
        if (!super.equals(o)) return false;
        Decoration that = (Decoration) o;
        return Double.compare(that.weight, weight) == 0 &&
                type == that.type &&
                Arrays.equals(metals, that.metals) &&
                Arrays.equals(gemsTypes, that.gemsTypes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), type, weight);
        result = 31 * result + Arrays.hashCode(metals);
        result = 31 * result + Arrays.hashCode(gemsTypes);
        return result;
    }

    @Override
    public String toString() {
        return "Decoration{" +
                "type=" + type +
                ", weight=" + weight +
                ", metals=" + Arrays.toString(metals) +
                ", gemsTypes=" + Arrays.toString(gemsTypes) +
                ", cost="+this.getCost()+
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
