package by.epam.task5004.logic;

import by.epam.task5004.treasures.Treasure;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TreasuresLogic {
    private List<Treasure> treasures;

    public TreasuresLogic(List<Treasure> treasures){
        if(treasures!=null){
            this.treasures=treasures;
        } else{
            this.treasures=new ArrayList<>();
        }
    }

    public Treasure findTheMostExpensive() {
        BigDecimal maxCost = BigDecimal.ZERO;
        Treasure mustExpensiveTreasure = null;
        for (Treasure treasure : treasures) {
            if (treasure.getCost().compareTo(maxCost) > 0) {
                maxCost = treasure.getCost();
                mustExpensiveTreasure = treasure;
            }
        }
        return mustExpensiveTreasure;
    }

    public List<Treasure> getTreasures(){
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        if(treasures!=null) {
            this.treasures = treasures;
        } else{
            this.treasures=new ArrayList<>();
        }
    }

    public List<Treasure> selectTreasuresForAGivenAmount(BigDecimal amount){
        BigDecimal currentAmount=BigDecimal.ZERO;
        List<Treasure> selectedTreasures=new ArrayList<>();
        treasures.sort(Comparator.comparing(Treasure::getCost).reversed());
        for (Treasure treasure : treasures) {
            currentAmount = currentAmount.add(treasure.getCost());
            if (currentAmount.compareTo(amount) <= 0) {
                selectedTreasures.add(treasure);
            } else {
                currentAmount = currentAmount.subtract(treasure.getCost());
            }
        }
        return selectedTreasures;
    }
}
