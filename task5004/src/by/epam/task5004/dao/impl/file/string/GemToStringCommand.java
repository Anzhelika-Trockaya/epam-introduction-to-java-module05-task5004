package by.epam.task5004.dao.impl.file.string;

import by.epam.task5004.bean.Gem;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;

public class GemToStringCommand implements TreasureToStringCommand{
    @Override
    public String execute(Treasure treasure) throws DAOException {
        String treasureString;
        Gem gem;

        if(treasure instanceof Gem) {
            gem=(Gem) treasure;
            treasureString = "Gem"
                    + " id=" + gem.getId()
                    + " type=" + gem.getType()
                    + " carat="+gem.getCarat()
                    + " cost="+gem.getCost();

            return treasureString;

        } else{
            throw new DAOException();
        }
    }
}
