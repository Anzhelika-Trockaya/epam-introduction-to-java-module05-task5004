package by.epam.task5004.controller.command.impl.parse.parser;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.controller.command.impl.parse.ParseException;
import by.epam.task5004.controller.command.impl.parse.command.ParseTreasureCommand;
import by.epam.task5004.controller.command.impl.parse.command.ParseTreasureCommandProvider;

public class TreasureParser {
    private static final TreasureParser instance = new TreasureParser();

    private TreasureParser() {
    }

    public static TreasureParser getInstance() {
        return instance;
    }

    public Treasure parse(String[] treasureStrings) throws ParseException {
        String treasureName;
        String[] treasureParams;
        ParseTreasureCommandProvider parseCommandProvider;
        ParseTreasureCommand parseCommand;
        Treasure treasure;

        treasureName = getTreasureName(treasureStrings);
        treasureParams = getTreasureParamsArray(treasureStrings);

        parseCommandProvider = new ParseTreasureCommandProvider();
        parseCommand = parseCommandProvider.getCommand(treasureName);
        treasure = parseCommand.execute(treasureParams);

        return treasure;
    }

    private String getTreasureName(String[] treasureStrings) throws ParseException {
        String name;
        String[] nameTreasureStrings;

        nameTreasureStrings = treasureStrings[0].split("=");

        if (nameTreasureStrings[0].equalsIgnoreCase("name")
                && nameTreasureStrings[1].matches("([A-Z][a-z]*)+")) {

            name = nameTreasureStrings[1];
            return name;

        } else {
            throw new ParseException("Incorrect treasures name!");
        }
    }

    private String[] getTreasureParamsArray(String[] treasureStrings) throws ParseException {
        String[] treasureParams;
        String parametersRegex;

        parametersRegex = "[a-zA-Z]+=(([a-zA-Z0-9.]+)|(\\{[^{]*}))";
        treasureParams = new String[treasureStrings.length - 1];

        for (int i = 1; i < treasureStrings.length; i++) {
            if (treasureStrings[i].matches(parametersRegex)) {
                treasureParams[i - 1] = treasureStrings[i];
            } else {
                throw new ParseException("Incorrect request");
            }
        }

        return treasureParams;
    }
}
