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
        int typePositionInArray;
        int caratPositionInArray;
        int costPositionInArray;

        parser = ParameterParser.getInstance();
        typePositionInArray = 0;
        caratPositionInArray = 1;
        costPositionInArray = 2;

        type = parser.parseGemType(treasureParams[typePositionInArray]);
        carat = parser.parseCarat(treasureParams[caratPositionInArray]);
        cost = parser.parseCost(treasureParams[costPositionInArray]);

        treasure = new Gem(type, carat, cost);

        return treasure;
    }
}
