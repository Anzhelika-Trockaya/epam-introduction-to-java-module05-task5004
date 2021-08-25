package com.epam.task5004.logic;

public class Menu {
    private static final String START_MENU_ACTION_1 = "- To view treasures press 1";
    private static final String START_MENU_ACTION_2 = "- To find the most expensive treasure press 2";
    private static final String START_MENU_ACTION_3 = "- To select treasures for a given amount press 3";
    private static final String START_MENU_ACTION_4 = "- To exit the application press 0";
    private static final String MENU_ACTION_1 = "- To return to the start menu press 1";
    private static final String MENU_ACTION_2 = "- To exit the application press 0";

    public void printStartMenu() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("--------------------------    DRAGON AND TREASURES    -------------------------");
        System.out.println("  MENU");
        System.out.println(START_MENU_ACTION_1);
        System.out.println(START_MENU_ACTION_2);
        System.out.println(START_MENU_ACTION_3);
        System.out.println(START_MENU_ACTION_4);
        System.out.println();
        System.out.println();
    }

    public void printMenu(){
        System.out.println();
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(MENU_ACTION_1);
        System.out.println(MENU_ACTION_2);
        System.out.println();
        System.out.println();
    }
}