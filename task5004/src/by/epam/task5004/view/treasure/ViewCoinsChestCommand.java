package by.epam.task5004.view.treasure;

import by.epam.task5004.bean.CoinsChest;
import by.epam.task5004.bean.Treasure;

public class ViewCoinsChestCommand implements ViewTreasureCommand {
    @Override
    public String execute(Treasure treasure) {
        String treasureString;
        CoinsChest chest;

        chest = (CoinsChest) treasure;
        treasureString = "CoinsChest"
                + " id=" + chest.getId()
                + " metal=" + chest.getMetal()
                + " coinsNumber=" + chest.getCoinsNumber()
                + " cost=" + chest.getCost();

        return treasureString;

    }
}
