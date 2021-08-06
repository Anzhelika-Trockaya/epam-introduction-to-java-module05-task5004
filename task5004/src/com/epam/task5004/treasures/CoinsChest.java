package com.epam.task5004.treasures;

import java.math.BigDecimal;

public class CoinsChest extends Treasure {
    private PreciousMetal metal;
    private int coinsNumber;

    public CoinsChest(PreciousMetal metal, int coinsNumber, BigDecimal cost) {
        super(cost);
        this.metal = metal;
        this.coinsNumber = coinsNumber;
    }

    public PreciousMetal getMetal() {
        return metal;
    }

    public void setMetal(PreciousMetal metal) {
        this.metal = metal;
    }

    public int getCoinsNumber() {
        return coinsNumber;
    }

    public void setCoinsNumber(int coinsNumber) {
        this.coinsNumber = coinsNumber;
    }

    @Override
    public String toString() {
        return "CoinsChest{" +
                "metal=" + metal +
                ", coinsNumber=" + coinsNumber +
                ", cost="+this.getCost()+
                '}';
    }
}
