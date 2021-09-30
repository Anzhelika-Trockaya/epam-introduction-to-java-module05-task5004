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
        int typePositionInArray;
        int weightPositionInArray;
        int metalsPositionInArray;
        int gemsPositionInArray;
        int costPositionInArray;

        parser = ParameterParser.getInstance();
        typePositionInArray = 0;
        weightPositionInArray = 1;
        metalsPositionInArray = 2;
        gemsPositionInArray = 3;
        costPositionInArray = 4;

        type = parser.parseDecorationType(treasureParams[typePositionInArray]);
        weight = parser.parseWeight(treasureParams[weightPositionInArray]);
        metals = parser.parseListOfMetals(treasureParams[metalsPositionInArray]);
        gemsTypes = parser.parseListOfGemsTypes(treasureParams[gemsPositionInArray]);
        cost = parser.parseCost(treasureParams[costPositionInArray]);

        treasure = new Decoration(type, weight, metals, gemsTypes, cost);

        return treasure;
    }
}
