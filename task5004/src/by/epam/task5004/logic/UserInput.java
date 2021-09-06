package by.epam.task5004.logic;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);;
    }

    public int readInt(){
        int input;
        try {
            input = scanner.nextInt();
        } catch(IllegalArgumentException exc){
            throw new IllegalArgumentException("Incorrect input!");
        }

        return input;
    }

    public BigDecimal readBigDecimal(){
        BigDecimal input;
        try {
            input = scanner.nextBigDecimal();
        } catch(IllegalArgumentException exc){
            throw new IllegalArgumentException("Incorrect input!");
        }

        return input;
    }

}
