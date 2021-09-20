package by.epam.task5004.dao.impl.file.string;

import by.epam.task5004.bean.CoinsChest;
import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;

public class CoinsChestToStringCommand implements TreasureToStringCommand {
    @Override
    public String execute(Treasure treasure) throws DAOException {
        String treasureString;
        CoinsChest chest;

        if(treasure instanceof CoinsChest) {
            chest=(CoinsChest) treasure;
            treasureString = "CoinsChest"
                    + " id=" + chest.getId()
                    + " metal=" + chest.getMetal()
                    + " coinsNumber="+chest.getCoinsNumber()
                    + " cost="+chest.getCost();

            return treasureString;

        } else{
            throw new DAOException();
        }
    }
}
