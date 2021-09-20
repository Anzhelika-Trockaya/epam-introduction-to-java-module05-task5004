package by.epam.task5004.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Tableware extends Treasure implements Serializable {
    private TablewareType type;
    private PreciousMetal metal;

    public Tableware(){
        super();
        this.type = TablewareType.OTHER;
        this.metal=PreciousMetal.OTHER;
    }

    public Tableware(TablewareType type, PreciousMetal metal, BigDecimal cost) {
        super(cost);
        this.type = type;
        this.metal = metal;
    }

    public Tableware(int id, TablewareType type, PreciousMetal metal, BigDecimal cost) {
        super(id, cost);
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
        Tableware tableware = (Tableware) o;
        return getId()== tableware.getId()&&
                type == tableware.type &&
                metal == tableware.metal &&
                getCost().equals(tableware.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), type, metal, getCost());
    }

    @Override
    public String toString() {
        return "Tableware{" +
                "id=" + getId() +
                ", type=" + type +
                ", metal=" + metal +
                ", cost=" + getCost() +
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
