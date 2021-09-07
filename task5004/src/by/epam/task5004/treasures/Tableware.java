package by.epam.task5004.treasures;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Tableware extends Treasure implements Serializable {
    private TablewareType type;
    private PreciousMetal metal;

    public Tableware(){
        this.type = TablewareType.OTHER;
        this.metal=PreciousMetal.OTHER;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tableware)) return false;
        if (!super.equals(o)) return false;
        Tableware tableware = (Tableware) o;
        return type == tableware.type &&
                metal == tableware.metal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, metal);
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
