package by.epam.task5004.controller.command.impl.parse.command;

import by.epam.task5004.bean.CoinsChest;
import by.epam.task5004.bean.PreciousMetal;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.controller.command.impl.parse.parser.ParameterParser;
import by.epam.task5004.controller.command.impl.parse.ParseException;

import java.math.BigDecimal;

public class ParseCoinsChestCommand implements ParseTreasureCommand {
    @Override
    public Treasure execute(String[] treasureParams) throws ParseException {
        Treasure treasure;
        ParameterParser parser;
        int metalPositionInArray;
        int coinsNumberPositionInArray;
        int costPositionInArray;

        PreciousMetal metal;
        int coinsNumber;
        BigDecimal cost;

        parser = ParameterParser.getInstance();

        metalPositionInArray = 0;
        coinsNumberPositionInArray = 1;
        costPositionInArray = 2;

        metal = parser.parseMetal(treasureParams[metalPositionInArray]);
        coinsNumber = parser.parseCoinsNumber(treasureParams[coinsNumberPositionInArray]);
        cost = parser.parseCost(treasureParams[costPositionInArray]);

        treasure = new CoinsChest(metal, coinsNumber, cost);

        return treasure;
    }


}
