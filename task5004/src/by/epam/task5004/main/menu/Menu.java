package by.epam.task5004.main.menu;

import by.epam.task5004.controller.Controller;

import java.math.BigDecimal;

public class Menu {
    private final UserInput userInput;
    private final Controller treasureController;

    public Menu(UserInput userInput, Controller treasureController) {
        this.userInput = userInput;
        this.treasureController = treasureController;
    }

    public void start() {
        int numberOfAction;

        while (true) {
            printStartMenu();
            numberOfAction = userInput.readInt("Enter number of action: ");
            processTheInputToTheStartMenu(numberOfAction);
        }
    }

    private void printStartMenu() {
        System.out.println("\n" + "-------------------------------------------------------------------------------");
        System.out.println("--------------------------    DRAGON AND TREASURES    -------------------------");
        System.out.println("  MENU");
        System.out.println("- To view treasures press 1");
        System.out.println("- To find the most expensive treasure press 2");
        System.out.println("- To select treasures for a given amount press 3");
        System.out.println("- To add treasure press 4");
        System.out.println("- To delete treasure press 5");
        System.out.println("\n");
        System.out.println("- To exit the application press 0");
        System.out.println("\n");
    }

    private void printMenu() {
        System.out.println("\n");
        System.out.println("\n" + "-------------------------------------------------------------------------------");
        System.out.println("- To return to the start menu press 1");
        System.out.println("- To exit the application press 0");
        System.out.println("\n");
    }

    private void printMessage(String message) {
        System.out.println("\n" + message);
    }


    private void processTheInputToTheStartMenu(int numberOfAction) {

        switch (numberOfAction) {
            case 0 -> System.exit(0);
            case 1 -> {
                viewAllTreasures();
                runExtraMenu();
            }
            case 2 -> {
                viewTheMostExpensive();
                runExtraMenu();
            }
            case 3 -> {
                treasuresForAmount();
                runExtraMenu();
            }
            case 4 -> {
                addTreasure();
                runExtraMenu();
            }
            case 5 -> {
                deleteTreasure();
                runExtraMenu();
            }
            default -> printMessage("Incorrect number of action!");
        }
    }

    private void runExtraMenu() {
        int numberOfAction;
        printMenu();
        numberOfAction = userInput.readInt("Enter number of action: ");
        processTheInputToExtraMenu(numberOfAction);
    }

    private void processTheInputToExtraMenu(int numberOfAction) {
        switch (numberOfAction) {
            case 0 -> System.exit(0);
            case 1 -> {
            }
            default -> {
                printMessage("Incorrect number of action!");

                printMenu();
                numberOfAction = userInput.readInt("Enter number of action: ");
                processTheInputToExtraMenu(numberOfAction);
            }
        }
    }

    private void viewAllTreasures() {
        String request;
        String response;

        request = "allTreasures";
        response = treasureController.doAction(request);
        printMessage(response);
    }

    private void viewTheMostExpensive() {
        String request;
        String response;

        request = "mostExpensiveTreasure";
        response = treasureController.doAction(request);
        printMessage(response);
    }

    private void treasuresForAmount() {
        String request;
        String response;
        BigDecimal amount;

        printMessage("\n  Treasures for a given amount  ");
        amount = userInput.readBigDecimal("Enter amount: ");

        request = "treasuresForAmount amount=" + amount.doubleValue();
        response = treasureController.doAction(request);
        printMessage(response);
    }

    private void deleteTreasure() {
        String request;
        String response;
        int id;

        printMessage("\n  Delete treasure  ");
        id = userInput.readInt("Enter id: ");
        request = "delete id=" + id;

        response = treasureController.doAction(request);
        printMessage(response);
    }

    private void addTreasure() {
        TreasuresStringReader reader;
        String request;
        String response;
        String treasuresString;

        printMessage("\n  Add treasure  ");
        reader = new TreasuresStringReader();
        treasuresString = reader.readTreasure(userInput);
        request = "add" + treasuresString;

        response = treasureController.doAction(request);
        printMessage(response);
    }

}
