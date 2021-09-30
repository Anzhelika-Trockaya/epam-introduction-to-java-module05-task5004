package by.epam.task5004.controller.command.impl.parse.command;

import by.epam.task5004.bean.PreciousMetal;
import by.epam.task5004.bean.Tableware;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.controller.command.impl.parse.parser.ParameterParser;
import by.epam.task5004.controller.command.impl.parse.ParseException;

import java.math.BigDecimal;

public class ParseTablewareCommand implements ParseTreasureCommand {
    @Override
    public Treasure execute(String[] treasureParams) throws ParseException {
        Treasure treasure;
        ParameterParser parser;

        Tableware.TablewareType type;
        PreciousMetal metal;
        BigDecimal cost;
        int typePositionInArray;
        int metalPositionInArray;
        int costPositionInArray;

        parser = ParameterParser.getInstance();
        typePositionInArray = 0;
        metalPositionInArray = 1;
        costPositionInArray = 2;

        type = parser.parseTablewareType(treasureParams[typePositionInArray]);
        metal = parser.parseMetal(treasureParams[metalPositionInArray]);
        cost = parser.parseCost(treasureParams[costPositionInArray]);

        treasure = new Tableware(type, metal, cost);

        return treasure;
    }
}
