package by.epam.task5004.controller.command.impl.parse.command;

import by.epam.task5004.bean.Gem;
import by.epam.task5004.bean.GemType;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.controller.command.impl.parse.parser.ParameterParser;
import by.epam.task5004.controller.command.impl.parse.ParseException;

import java.math.BigDecimal;

public class ParseGemCommand implements ParseTreasureCommand {
    @Override
    public Treasure execute(String[] treasureParams) throws ParseException {
        Treasure treasure;
        ParameterParser parser;

        GemType type;
        double carat;
        BigDecimal cost;

        parser = ParameterParser.getInstance();

        type = parser.parseGemType(treasureParams[0]);
        carat = parser.parseCarat(treasureParams[1]);
        cost = parser.parseCost(treasureParams[2]);

        treasure = new Gem(type, carat, cost);

        return treasure;
    }
}
