package by.epam.task5004.dao.impl.file.string;

import by.epam.task5004.bean.*;
import by.epam.task5004.dao.DAOException;

import java.util.List;

public class DecorationToStringCommand implements TreasureToStringCommand {
    @Override
    public String execute(Treasure treasure) throws DAOException {
        String treasureString;
        Decoration decoration;

        if (treasure instanceof Decoration) {
            decoration = (Decoration) treasure;
            treasureString = "Decoration"
                    + " id=" + decoration.getId()
                    + " type=" + decoration.getType()
                    + " weight=" + decoration.getWeight()
                    + " metals=" + listOfMetalsToString(decoration.getMetals())
                    + " gemsTypes=" + listOfGemsTypesToString(decoration.getGemsTypes())
                    + " cost=" + decoration.getCost();

            return treasureString;

        } else {
            throw new DAOException();
        }
    }

    private String listOfMetalsToString(List<PreciousMetal> metals) throws DAOException {
        String metalsString;

        if(!metals.isEmpty()) {
            metalsString = "{";
            metalsString += metals.get(0);

            for (int i = 1; i < metals.size(); i++) {
                metalsString += " " + metals.get(i);
            }

            metalsString += "}";

            return metalsString;
        } else{
            throw new DAOException("Decoration without any metals!");
        }
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
