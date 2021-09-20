package by.epam.task5004.dao.impl.file.parse.command;

import by.epam.task5004.bean.Gem;
import by.epam.task5004.bean.GemType;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;
import by.epam.task5004.dao.impl.file.parse.parser.ParameterParser;

import java.math.BigDecimal;

public class ParseGemCommand implements ParseTreasureCommand{
    @Override
    public Treasure execute(String[] treasureParams) throws DAOException {
        Treasure treasure;
        ParameterParser parser;

        int id;
        GemType type;
        double carat;
        BigDecimal cost;

        parser = ParameterParser.getInstance();

        id = parser.parseId(treasureParams[0]);
        type=parser.parseGemType(treasureParams[1]);
        carat = parser.parseCarat(treasureParams[2]);
        cost = parser.parseCost(treasureParams[3]);

        treasure=new Gem(id, type, carat, cost);

        return treasure;
    }
}
