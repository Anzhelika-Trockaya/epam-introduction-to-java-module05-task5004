package by.epam.task5004.view.treasure;

import by.epam.task5004.bean.Gem;
import by.epam.task5004.bean.Treasure;

public class ViewGemCommand implements ViewTreasureCommand {
    @Override
    public String execute(Treasure treasure) {
        String treasureString;
        Gem gem;

        gem = (Gem) treasure;
        treasureString = "Gem"
                + " id=" + gem.getId()
                + " type=" + gem.getType()
                + " carat=" + gem.getCarat()
                + " cost=" + gem.getCost();

        return treasureString;

    }
}
