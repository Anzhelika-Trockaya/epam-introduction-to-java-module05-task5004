package by.epam.task5004.view.treasure;

import by.epam.task5004.bean.Tableware;
import by.epam.task5004.bean.Treasure;

public class ViewTablewareCommand implements ViewTreasureCommand {
    @Override
    public String execute(Treasure treasure) {
        String treasureString;
        Tableware tableware;

        tableware = (Tableware) treasure;
        treasureString = "Tableware"
                + " id=" + tableware.getId()
                + " type=" + tableware.getType()
                + " metal=" + tableware.getMetal()
                + " cost=" + tableware.getCost();

        return treasureString;
    }
}
