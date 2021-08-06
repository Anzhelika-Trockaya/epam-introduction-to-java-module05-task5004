package com.epam.task5004.treasures;

import java.math.BigDecimal;

public class Gem extends Treasure {
    private GemType type;
    private double carat;

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
    public String toString() {
        return "Gem{" +
                "type=" + type +
                ", carat=" + carat +
                ", cost="+this.getCost()+
                '}';
    }
}

