package com.epam.task5004.treasures;

import java.math.BigDecimal;
import java.util.Arrays;

public class Decoration extends Treasure {
    private DecorationType type;
    private double weight;
    private PreciousMetal[] metals;
    private GemType[] gemsTypes;

    public Decoration(DecorationType type, double weight, PreciousMetal[] metals, BigDecimal cost) {
        super(cost);
        this.type = type;
        this.weight = weight;
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
