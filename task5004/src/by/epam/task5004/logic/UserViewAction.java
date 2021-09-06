package by.epam.task5004.logic;

import by.epam.task5004.treasures.Treasure;

import java.math.BigDecimal;
import java.util.List;

public class UserViewAction {

    private UserInput input;
    private TreasuresLogic treasuresLogic;

    public UserViewAction(UserInput input, List<Treasure> treasures){
        if(input!=null){
            this.input=input;
        } else{
            throw new IllegalArgumentException("Incorrect UserInput!");
        }

        treasuresLogic=new TreasuresLogic(treasures);
    }

    public void start() {
        int numberOfAction;

        OutputUtil.printStartMenu();

        try {
            numberOfAction = input.readInt();
            processTheInputToTheStartMenu(numberOfAction);
        } catch(IllegalArgumentException exc){
            OutputUtil.printMessage(exc.getMessage());
            start();
        }
    }

    public void processTheInputToTheStartMenu(int numberOfAction) {
        switch (numberOfAction) {
            case 0 -> System.exit(0);
            case 1 -> viewAllTreasures();
            case 2 -> viewTheMostExpensive();
            case 3 -> treasuresForAmount();
            default -> {
                throw new IllegalArgumentException("Incorrect number of action!");
            }
        }
    }

    private void viewAllTreasures(){
        List<Treasure> allTreasures;

        allTreasures = treasuresLogic.getTreasures();
        OutputUtil.printMessage("---------------  All treasures:  ---------------");
        OutputUtil.printTreasures(allTreasures);
        processTheInputToMenu();
    }

    public void processTheInputToMenu() {
        int numberOfAction;

        OutputUtil.printMenu();

        try {
            numberOfAction = input.readInt();
            switch (numberOfAction) {
                case 0 -> System.exit(0);
                case 1 -> {
                    start();
                }
                default -> {
                    OutputUtil.printMessage("Incorrect number of action!");
                    processTheInputToMenu();
                }
            }
        } catch(IllegalArgumentException exc){
            OutputUtil.printMessage(exc.getMessage());
            processTheInputToMenu();
        }

    }

    private void viewTheMostExpensive(){
        Treasure mostExpensiveTreasure;

        OutputUtil.printMessage("---------------  The most expensive treasure is:  ---------------");
        mostExpensiveTreasure=treasuresLogic.findTheMostExpensive();
        OutputUtil.printTreasure(mostExpensiveTreasure);
        processTheInputToMenu();
    }
    private void treasuresForAmount(){
        BigDecimal amount;
        List<Treasure> selectedTreasures;

        OutputUtil.printMessage("----------------  Treasures for a given amount  -----------------");
        OutputUtil.printMessage("Enter amount: ");

        amount = input.readBigDecimal();

        if(amount.compareTo(BigDecimal.ZERO)>0){
            selectedTreasures = treasuresLogic.selectTreasuresForAGivenAmount(amount);
            if(selectedTreasures.size()>0){
                OutputUtil.printTreasures(selectedTreasures);
            } else{
                OutputUtil.printMessage("All treasures are most worth then amount!");
            }
        } else{
            OutputUtil.printMessage("Amount must be positive!");
            treasuresForAmount();
        }
        processTheInputToMenu();
    }
}
