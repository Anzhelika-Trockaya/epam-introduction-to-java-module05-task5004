package by.epam.task5004.dao.impl.file.parse.command;

import by.epam.task5004.bean.CoinsChest;
import by.epam.task5004.bean.PreciousMetal;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;
import by.epam.task5004.dao.impl.file.parse.parser.ParameterParser;

import java.math.BigDecimal;

public class ParseCoinsChestCommand implements ParseTreasureCommand {
    @Override
    public Treasure execute(String[] treasureParams) throws DAOException {
        Treasure treasure;
        ParameterParser parser;

        int id;
        PreciousMetal metal;
        int coinsNumber;
        BigDecimal cost;

        parser = ParameterParser.getInstance();

        id = parser.parseId(treasureParams[0]);
        metal = parser.parseMetal(treasureParams[1]);
        coinsNumber = parser.parseCoinsNumber(treasureParams[2]);
        cost = parser.parseCost(treasureParams[3]);

        treasure = new CoinsChest(id, metal, coinsNumber, cost);

        return treasure;
    }


}
