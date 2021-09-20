package by.epam.task5004.dao.impl.file.parse.command;

import by.epam.task5004.bean.PreciousMetal;
import by.epam.task5004.bean.Tableware;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;
import by.epam.task5004.dao.impl.file.parse.parser.ParameterParser;

import java.math.BigDecimal;

public class ParseTablewareCommand implements ParseTreasureCommand {
    @Override
    public Treasure execute(String[] treasureParams) throws DAOException {
        Treasure treasure;
        ParameterParser parser;

        int id;
        Tableware.TablewareType type;
        PreciousMetal metal;
        BigDecimal cost;

        parser = ParameterParser.getInstance();

        id = parser.parseId(treasureParams[0]);
        type = parser.parseTablewareType(treasureParams[1]);
        metal = parser.parseMetal(treasureParams[2]);
        cost = parser.parseCost(treasureParams[3]);

        treasure = new Tableware(id, type, metal, cost);

        return treasure;
    }
}
