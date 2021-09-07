package by.epam.task5004.treasures;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CoinsChest extends Treasure implements Serializable {
    private PreciousMetal metal;
    private int coinsNumber;

    public CoinsChest(){
        this.metal=PreciousMetal.OTHER;
        this.coinsNumber=0;
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
        if (!super.equals(o)) return false;
        CoinsChest that = (CoinsChest) o;
        return coinsNumber == that.coinsNumber &&
                metal == that.metal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), metal, coinsNumber);
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
