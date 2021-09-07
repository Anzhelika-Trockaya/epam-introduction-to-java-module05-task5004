package by.epam.task5004.view;

import by.epam.task5004.bean.*;

import java.util.Arrays;
import java.util.List;

public class OutputUtil {
    private static final String TO_VIEW = "- To view treasures press 1";
    private static final String TO_FIND = "- To find the most expensive treasure press 2";
    private static final String TO_SELECT_FOR_AMOUNT = "- To select treasures for a given amount press 3";
    private static final String TO_EXIT = "- To exit the application press 0";
    private static final String TO_RETURN = "- To return to the start menu press 1";
    private static final String ENTER_NUMBER_OF_ACTION = "Enter number of action: ";
    private static final String LINE = "-------------------------------------------------------------------------------";
    private static final String DRAGON_AND_TREASURES =
            "--------------------------    DRAGON AND TREASURES    -------------------------";


    public static void printStartMenu() {
        System.out.println("\n" + LINE);
        System.out.println(DRAGON_AND_TREASURES);
        System.out.println("  MENU");
        System.out.println(TO_VIEW);
        System.out.println(TO_FIND);
        System.out.println(TO_SELECT_FOR_AMOUNT);
        System.out.println(TO_EXIT);
        System.out.println("\n");
        System.out.print(ENTER_NUMBER_OF_ACTION);
    }

    public static void printMenu() {
        System.out.println("\n");
        System.out.println(LINE);
        System.out.println(TO_RETURN);
        System.out.println(TO_EXIT);
        System.out.println("\n");
        System.out.print(ENTER_NUMBER_OF_ACTION);
    }

    public static void printMessage(String message) {
        System.out.println("\n" + message);
    }

    public static void printTreasures(List<Treasure> treasures) {
        for (Treasure treasure : treasures) {
            printTreasure(treasure);
        }
    }

    public static void printTreasure(Treasure treasure) {
        if (treasure instanceof CoinsChest) {
            printCoinsChest(treasure);
        } else if (treasure instanceof Decoration) {
            printDecoration(treasure);
        } else if (treasure instanceof Gem) {
            printGem(treasure);
        } else if (treasure instanceof Tableware) {
            printTableware(treasure);
        } else {
            System.out.println("Exception! Unidentified treasure!");
        }
    }

    private static void printTableware(Treasure treasure) {
        Tableware tableware;

        tableware = (Tableware) treasure;

        System.out.println("Tableware | type " + tableware.getType() +
                " | metal " + tableware.getMetal().toString() +
                " | cost " + tableware.getCost().toString());
    }

    private static void printGem(Treasure treasure) {
        Gem gem;

        gem = (Gem) treasure;

        System.out.println("Gem | type " + gem.getType() +
                " | carat " + gem.getCarat() +
                " | cost " + gem.getCost().toString());
    }

    private static void printDecoration(Treasure treasure) {
        Decoration decoration;

        decoration = (Decoration) treasure;

        System.out.println("Decoration | type " + decoration.getType() +
                " | weight " + decoration.getWeight() +
                " | metals " + Arrays.toString(decoration.getMetals()) +
                " | gemsTypes " + Arrays.toString(decoration.getGemsTypes()) +
                " | cost " + decoration.getCost().toString());
    }

    private static void printCoinsChest(Treasure treasure) {
        CoinsChest coinsChest;

        coinsChest = (CoinsChest) treasure;

        System.out.println("Coins chest | coins metal " + coinsChest.getMetal() +
                " | coins number " + coinsChest.getCoinsNumber() +
                " | cost " + coinsChest.getCost().toString());
    }
}