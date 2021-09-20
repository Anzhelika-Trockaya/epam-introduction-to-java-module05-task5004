package by.epam.task5004.dao.impl.file.string;

import by.epam.task5004.bean.Tableware;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;

public class TablewareToStringCommand implements TreasureToStringCommand{
    @Override
    public String execute(Treasure treasure) throws DAOException {
        String treasureString;
        Tableware tableware;

        if(treasure instanceof Tableware) {
            tableware=(Tableware) treasure;
            treasureString = "Tableware"
                    + " id=" + tableware.getId()
                    + " type=" + tableware.getType()
                    + " metal="+tableware.getMetal()
                    + " cost="+tableware.getCost();

            return treasureString;

        } else{
            throw new DAOException();
        }
    }
}
