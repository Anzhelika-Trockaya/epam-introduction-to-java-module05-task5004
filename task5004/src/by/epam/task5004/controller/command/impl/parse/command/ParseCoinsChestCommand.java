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

        PreciousMetal metal;
        int coinsNumber;
        BigDecimal cost;

        parser = ParameterParser.getInstance();

        metal = parser.parseMetal(treasureParams[0]);
        coinsNumber = parser.parseCoinsNumber(treasureParams[1]);
        cost = parser.parseCost(treasureParams[2]);

        treasure = new CoinsChest(metal, coinsNumber, cost);

        return treasure;
    }


}
