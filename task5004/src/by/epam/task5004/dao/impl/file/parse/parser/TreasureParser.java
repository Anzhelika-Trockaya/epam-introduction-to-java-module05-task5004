package by.epam.task5004.dao.impl.file.parse.parser;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;
import by.epam.task5004.dao.impl.file.parse.command.ParseTreasureCommand;
import by.epam.task5004.dao.impl.file.parse.command.ParseTreasureCommandProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureParser {
    private static final TreasureParser instance = new TreasureParser();

    private TreasureParser() {
    }

    public static TreasureParser getInstance() {
        return instance;
    }

    public Treasure parse(String treasureString) throws DAOException {
        String treasureName;
        String[] treasureParams;
        ParseTreasureCommandProvider parseCommandProvider;
        ParseTreasureCommand parseCommand;
        Treasure treasure;

        treasureName = getTreasureName(treasureString);
        treasureParams = getTreasureParamsArray(treasureString);

        parseCommandProvider = new ParseTreasureCommandProvider();
        parseCommand = parseCommandProvider.getCommand(treasureName);
        treasure = parseCommand.execute(treasureParams);

        return treasure;
    }

    private String getTreasureName(String treasureString) {
        StringBuilder nameBuilder;
        char[] treasureStringsChars;

        nameBuilder = new StringBuilder();
        treasureStringsChars = treasureString.toCharArray();

        for (int i = 0; i < treasureStringsChars.length; i++) {
            if (treasureStringsChars[i] != ' ') {
                nameBuilder.append(treasureStringsChars[i]);
            } else {
                break;
            }
        }

        return nameBuilder.toString();
    }

    private String[] getTreasureParamsArray(String treasureString) {
        List<String> treasureParams;
        Pattern parametersPattern;
        Matcher parametersMatcher;

        parametersPattern = Pattern.compile("[a-zA-Z]+=(([a-zA-Z0-9.]+)|(\\{[^{]*}))");
        parametersMatcher = parametersPattern.matcher(treasureString);
        treasureParams = new ArrayList<>();

        while (parametersMatcher.find()) {
            treasureParams.add(parametersMatcher.group());
        }

        return treasureParams.toArray(new String[treasureParams.size()]);
    }
}
