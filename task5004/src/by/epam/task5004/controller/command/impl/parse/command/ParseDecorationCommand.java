package by.epam.task5004.controller.command.impl.parse.command;

import by.epam.task5004.bean.Decoration;
import by.epam.task5004.bean.GemType;
import by.epam.task5004.bean.PreciousMetal;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.controller.command.impl.parse.parser.ParameterParser;
import by.epam.task5004.controller.command.impl.parse.ParseException;

import java.math.BigDecimal;
import java.util.List;

public class ParseDecorationCommand implements ParseTreasureCommand {
    @Override
    public Treasure execute(String[] treasureParams) throws ParseException {
        Treasure treasure;
        ParameterParser parser;

        Decoration.DecorationType type;
        double weight;
        List<PreciousMetal> metals;
        List<GemType> gemsTypes;
        BigDecimal cost;

        parser = ParameterParser.getInstance();

        type = parser.parseDecorationType(treasureParams[0]);
        weight = parser.parseWeight(treasureParams[1]);
        metals = parser.parseListOfMetals(treasureParams[2]);
        gemsTypes = parser.parseListOfGemsTypes(treasureParams[3]);
        cost = parser.parseCost(treasureParams[4]);

        treasure = new Decoration(type, weight, metals, gemsTypes, cost);

        return treasure;
    }
}
