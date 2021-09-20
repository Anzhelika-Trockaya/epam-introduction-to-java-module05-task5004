package by.epam.task5004.main.menu;

public class TreasuresStringReader {
    public TreasuresStringReader(){
    }

    public String readTreasure(UserInput userInput) {
        String treasureString;
        String name;

        name = userInput.readString("Enter name of treasure: ");

        treasureString = switch (name) {
            case "CoinsChest" -> readCoinsChestsString(userInput);
            case "Decoration" -> readDecorationsString(userInput);
            case "Gem" -> readGemString(userInput);
            case "Tableware" -> readTablewareString(userInput);
            default -> "";
        };

        return treasureString;
    }

    private String readCoinsChestsString(UserInput userInput) {
        String coinsChestString = " name=CoinsChest";
        String input;

        input = userInput.readString("Enter metal (TO UPPER CASE):");
        coinsChestString += " metal=" + input;
        input = userInput.readString("Enter number of coins:");
        coinsChestString += " coinsNumber=" + input;
        input = userInput.readString("Enter cost:");
        coinsChestString += " cost=" + input;

        return coinsChestString;
    }

    private String readDecorationsString(UserInput userInput) {
        String decorationsString = " name=Decoration";
        String input;

        input = userInput.readString("Enter type of decoration: (TO UPPER CASE)");
        decorationsString += " type=" + input;
        input = userInput.readString("Enter weight:");
        decorationsString += " weight=" + input;
        input = userInput.readString("Enter precious metals (TO UPPER CASE, through a space): ");
        decorationsString += " metals={" + input + "}";
        input = userInput.readString("Enter gems types (TO UPPER CASE, through a space), or press \"enter\": ");
        decorationsString += " gemsTypes={" + input + "}";
        input = userInput.readString("Enter cost:");
        decorationsString += " cost=" + input;

        return decorationsString;
    }

    private String readGemString(UserInput userInput) {
        String gemString = " name=Gem";
        String input;

        input = userInput.readString("Enter gems type (TO UPPER CASE):");
        gemString += " type=" + input;
        input = userInput.readString("Enter number of carat:");
        gemString += " carat=" + input;
        input = userInput.readString("Enter cost:");
        gemString += " cost=" + input;

        return gemString;
    }

    private String readTablewareString(UserInput userInput) {
        String tablewareString = " name=Tableware";
        String input;

        input = userInput.readString("Enter tableware type (TO UPPER CASE):");
        tablewareString += " type=" + input;
        input = userInput.readString("Enter metal of tableware (TO UPPER CASE):");
        tablewareString += " metal=" + input;
        input = userInput.readString("Enter cost:");
        tablewareString += " cost=" + input;

        return tablewareString;
    }
}
