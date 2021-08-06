package com.epam.task5004.treasures;

import java.math.BigDecimal;

public class Treasure {
    private BigDecimal cost;

    public Treasure(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }


}
