package by.epam.task5004.view;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.view.treasure.ViewTreasureCommand;
import by.epam.task5004.view.treasure.ViewTreasureCommandProvider;

import java.util.List;

public class UserActionViewer {
    public static String theMostExpensiveTreasureAnswer(Treasure treasure) {
        String answer;
        ViewTreasureCommandProvider viewTreasureCommandProvider;
        ViewTreasureCommand viewTreasureCommand;

        if (treasure != null) {
            viewTreasureCommandProvider = new ViewTreasureCommandProvider();
            viewTreasureCommand = viewTreasureCommandProvider.getCommand(treasure.getClass().getSimpleName());
            answer = "0 The most expensive treasure:\n" + viewTreasureCommand.execute(treasure);
        } else {
            answer = "0 No treasure";
        }

        return answer;
    }

    public static String answer(String message){
        return message;
    }

    public static String exceptionAnswer(Exception exception) {
        String answer;

        answer = "-1 There was an exception" + exception.getMessage();

        return answer;
    }

    public static String addingAnswer(boolean areParamsCorrect) {
        String answer;

        if (areParamsCorrect) {
            answer = "0 Treasures added";
        } else {
            answer = "1 Treasure is not added, as parameters is not correct!";
        }

        return answer;
    }

    public static String deleteAnswer(boolean isCorrectId) {
        String answer;

        if (isCorrectId) {
            answer = "0 Treasure deleted.";
        } else {
            answer = "1 Treasure is not deleted, as id is not correct!";
        }

        return answer;
    }

    public static String treasuresForAGivenAmountAnswer(boolean isAmountCorrect, List<Treasure> treasuresForAmount) {
        String answer;

        if (isAmountCorrect) {

            if (!treasuresForAmount.isEmpty()) {
                answer = "0 Selected treasures:\n";
                answer += treasuresListToString(treasuresForAmount);
            } else {
                answer = "0 No treasures for a given amount";
            }

        } else {
            answer = "1 Not selected treasures, as amount is not correct!";
        }

        return answer;
    }

    public static String getAllTreasuresAnswer(List<Treasure> treasures) {
        String answer;

        if (!treasures.isEmpty()) {
            answer = "0 All treasures:\n";
            answer += treasuresListToString(treasures);
        } else {
            answer = "0 No treasures";
        }


        return answer;
    }

    private static String treasuresListToString(List<Treasure> treasures) {
        StringBuilder treasuresStringBuilder;
        ViewTreasureCommandProvider viewTreasureCommandProvider;
        ViewTreasureCommand viewTreasureCommand;

        viewTreasureCommandProvider = new ViewTreasureCommandProvider();
        treasuresStringBuilder = new StringBuilder();

        for (Treasure treasure : treasures) {
            viewTreasureCommand = viewTreasureCommandProvider.getCommand(treasure.getClass().getSimpleName());
            treasuresStringBuilder.append(viewTreasureCommand.execute(treasure));
            treasuresStringBuilder.append("\n");
        }

        return treasuresStringBuilder.toString();
    }
}
