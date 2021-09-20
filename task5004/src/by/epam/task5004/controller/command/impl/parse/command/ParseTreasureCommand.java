package by.epam.task5004.controller.command.impl.parse.command;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.controller.command.impl.parse.ParseException;

public interface ParseTreasureCommand {
    Treasure execute(String[] params) throws ParseException;
}
