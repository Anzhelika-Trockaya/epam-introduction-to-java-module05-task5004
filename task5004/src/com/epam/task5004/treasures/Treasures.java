package com.epam.task5004.treasures;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

public class Treasures {
    public static Treasure findTheMostExpensive(ArrayList<Treasure> treasures) {
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

    public static void printTreasures(ArrayList<Treasure> treasures){
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
        }
    }

    public static ArrayList<Treasure> selectTreasuresForAGivenAmount(ArrayList<Treasure> treasures, BigDecimal amount){
        BigDecimal currentAmount=BigDecimal.ZERO;
        ArrayList<Treasure> selectedTreasures=new ArrayList<>();
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
