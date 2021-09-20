package by.epam.task5004.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CoinsChest extends Treasure implements Serializable {
    private PreciousMetal metal;
    private int coinsNumber;

    public CoinsChest() {
        super();
        this.metal = PreciousMetal.OTHER;
        this.coinsNumber = 0;
    }

    public CoinsChest(int id, PreciousMetal metal, int coinsNumber, BigDecimal cost) {
        super(id, cost);
        this.metal = metal;
        this.coinsNumber = coinsNumber;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoinsChest)) return false;
        CoinsChest that = (CoinsChest) o;
        return getId()==that.getId() &&
                coinsNumber == that.coinsNumber &&
                metal == that.metal &&
                getCost().equals(that.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),metal, coinsNumber, getCost());
    }

    @Override
    public String toString() {
        return "CoinsChest{" +
                "id=" + getId() +
                ", metal=" + metal +
                ", coinsNumber=" + coinsNumber +
                ", cost=" + this.getCost() +
                '}';
    }
}
