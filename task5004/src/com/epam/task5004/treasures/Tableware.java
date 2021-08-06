package com.epam.task5004.treasures;

import java.math.BigDecimal;

public class Tableware extends Treasure {
    private TablewareType type;
    private PreciousMetal metal;

    public Tableware(TablewareType type, PreciousMetal metal, BigDecimal cost) {
        super(cost);
        this.type = type;
        this.metal = metal;
    }

    public TablewareType getType() {
        return type;
    }

    public void setType(TablewareType type) {
        this.type = type;
    }

    public PreciousMetal getMetal() {
        return metal;
    }

    public void setMetal(PreciousMetal metal) {
        this.metal = metal;
    }

    @Override
    public String toString() {
        return "Tableware{" +
                "type=" + type +
                ", metal=" + metal +
                ", cost="+this.getCost()+
                '}';
    }

    public enum TablewareType {
        BOWL,
        DISH,
        JUG,
        SPOON,
        FORK,
        KNIFE,
        OTHER
    }
}
