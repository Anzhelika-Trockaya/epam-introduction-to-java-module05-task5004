package com.epam.task5004.logic;

import com.epam.task5004.treasures.Treasure;
import com.epam.task5004.treasures.Treasures;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {

    private int input;
    private final Menu menu = new Menu();
    private final ArrayList<Treasure> treasures;
    private final Scanner scanner;

    public Logic(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
        scanner = new Scanner(System.in);
    }

    public void start() {
        menu.printStartMenu();
        processTheInputToTheStartMenu();
    }

    public void readNumberOfAction() {
        System.out.print("Enter number of action: ");
        input = scanner.nextInt();
    }

    public void processTheInputToTheStartMenu() {
        readNumberOfAction();
        System.out.println();
        switch (input) {
            case 0 -> System.exit(0);
            case 1 -> performAction1();
            case 2 -> performAction2();
            case 3 -> performAction3();
            default -> {
                System.out.println("Incorrect number of action!");
                processTheInputToTheStartMenu();
            }
        }
    }

    public void processTheInputToMenu() {
        readNumberOfAction();
        System.out.println();
        switch (input) {
            case 0 -> System.exit(0);
            case 1 -> {
                menu.printStartMenu();
                processTheInputToTheStartMenu();
            }
            default -> {
                System.out.println("Incorrect number of action!");
                processTheInputToMenu();
            }
        }
    }

    private void performAction1(){
        System.out.println("---------------  All treasures:  ---------------");
        Treasures.printTreasures(treasures);
        menu.printMenu();
        processTheInputToMenu();
    }

    private void performAction2(){
        System.out.println("---------------  The most expensive treasure is:  ---------------");
        System.out.println(Treasures.findTheMostExpensive(treasures));
        menu.printMenu();
        processTheInputToMenu();
    }
    private void performAction3(){
        System.out.println("----------------  Treasures for a given amount  -----------------");
        System.out.print("Enter amount: ");
        BigDecimal amount = scanner.nextBigDecimal();
        if(amount.compareTo(BigDecimal.ZERO)>0){
            ArrayList<Treasure> selectedTreasures = Treasures.selectTreasuresForAGivenAmount(treasures,amount);
            if(selectedTreasures.size()>0){
                System.out.println();
                Treasures.printTreasures(selectedTreasures);
            } else{
                System.out.println("All treasures are most worth then amount!");
            }
        } else{
            System.out.println("Amount must be positive!");
            performAction3();
        }
        menu.printMenu();
        processTheInputToMenu();
    }
}
