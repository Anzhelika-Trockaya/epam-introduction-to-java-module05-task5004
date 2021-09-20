package by.epam.task5004.dao.impl.file.string;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;

public interface TreasureToStringCommand {
    String execute(Treasure treasure) throws DAOException;
}
