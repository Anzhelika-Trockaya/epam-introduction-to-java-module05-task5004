package by.epam.task5004.dao.impl.file.parse.command;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;

public interface ParseTreasureCommand {
    Treasure execute(String[] params) throws DAOException;
}
