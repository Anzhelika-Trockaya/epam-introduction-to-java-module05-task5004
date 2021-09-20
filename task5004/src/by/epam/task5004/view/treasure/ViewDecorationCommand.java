package by.epam.task5004.view.treasure;

import by.epam.task5004.bean.Decoration;
import by.epam.task5004.bean.GemType;
import by.epam.task5004.bean.PreciousMetal;
import by.epam.task5004.bean.Treasure;

import java.util.List;

public class ViewDecorationCommand implements ViewTreasureCommand {
    @Override
    public String execute(Treasure treasure) {
        String treasureString;
        Decoration decoration;

        decoration = (Decoration) treasure;
        treasureString = "Decoration"
                + " id=" + decoration.getId()
                + " type=" + decoration.getType()
                + " weight=" + decoration.getWeight()
                + " metals=" + listOfMetalsToString(decoration.getMetals())
                + " gemsTypes=" + listOfGemsTypesToString(decoration.getGemsTypes())
                + " cost=" + decoration.getCost();

        return treasureString;
    }

    private String listOfMetalsToString(List<PreciousMetal> metals) {
        String metalsString;

        metalsString = "{";
        metalsString += metals.get(0);

        for (int i = 1; i < metals.size(); i++) {
            metalsString += " " + metals.get(i);
        }

        metalsString += "}";

        return metalsString;
    }

    private String listOfGemsTypesToString(List<GemType> gemsTypes) {
        String gemsTypesString;

        if (gemsTypes == null || gemsTypes.isEmpty()) {
            gemsTypesString = "{}";
        } else {
            gemsTypesString = "{";
            gemsTypesString += gemsTypes.get(0);

            for (int i = 1; i < gemsTypes.size(); i++) {
                gemsTypesString += " " + gemsTypes.get(i);
            }

            gemsTypesString += "}";
        }

        return gemsTypesString;
    }
}
