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

        parser = ParameterParser.getInstance();

        type = parser.parseTablewareType(treasureParams[0]);
        metal = parser.parseMetal(treasureParams[1]);
        cost = parser.parseCost(treasureParams[2]);

        treasure = new Tableware(type, metal, cost);

        return treasure;
    }
}
