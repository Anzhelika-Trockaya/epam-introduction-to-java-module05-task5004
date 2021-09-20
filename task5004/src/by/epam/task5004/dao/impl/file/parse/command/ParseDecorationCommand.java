package by.epam.task5004.dao.impl.file.parse.command;

import by.epam.task5004.bean.Decoration;
import by.epam.task5004.bean.GemType;
import by.epam.task5004.bean.PreciousMetal;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;
import by.epam.task5004.dao.impl.file.parse.parser.ParameterParser;

import java.math.BigDecimal;
import java.util.List;

public class ParseDecorationCommand implements ParseTreasureCommand {
    @Override
    public Treasure execute(String[] treasureParams) throws DAOException {
        Treasure treasure;
        ParameterParser parser;

        int id;
        Decoration.DecorationType type;
        double weight;
        List<PreciousMetal> metals;
        List<GemType> gemsTypes;
        BigDecimal cost;

        parser = ParameterParser.getInstance();

        id = parser.parseId(treasureParams[0]);
        type = parser.parseDecorationType(treasureParams[1]);
        weight = parser.parseWeight(treasureParams[2]);
        metals = parser.parseListOfMetals(treasureParams[3]);
        gemsTypes = parser.parseListOfGemsTypes(treasureParams[4]);
        cost = parser.parseCost(treasureParams[5]);

        treasure = new Decoration(id, type, weight, metals, gemsTypes, cost);

        return treasure;
    }
}
