package by.epam.task5004.main.menu;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt(String message) {
        String input;
        int value;

        System.out.println(message);
        input = scanner.nextLine();
        try {
            value = Integer.parseInt(input);
        } catch (IllegalArgumentException exc) {
            value = -1;
        }

        return value;
    }

    public BigDecimal readBigDecimal(String message) {
        String input;
        BigDecimal value;

        System.out.println(message);
        input=scanner.nextLine();
        try {
            value = BigDecimal.valueOf(Double.parseDouble(input));
        } catch (IllegalArgumentException exc) {
            value = BigDecimal.valueOf(-1.0);
        }

        return value;
    }

    public String readString(String message){
        String input;

        System.out.println(message);
        input = scanner.nextLine();

        return input;
    }

}
