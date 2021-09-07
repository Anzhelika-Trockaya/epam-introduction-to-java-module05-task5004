package by.epam.task5004.view;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt() {
        String input;
        int value;

        input = scanner.nextLine();
        try {
            value = Integer.parseInt(input);
        } catch (IllegalArgumentException exc) {
            value = -1;
        }

        return value;
    }

    public BigDecimal readBigDecimal() {
        String input;
        BigDecimal value;

        input=scanner.nextLine();
        try {
            value = BigDecimal.valueOf(Double.parseDouble(input));
        } catch (IllegalArgumentException exc) {
            value = BigDecimal.valueOf(-1.0);
        }

        return value;
    }

}
