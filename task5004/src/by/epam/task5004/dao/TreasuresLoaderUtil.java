package by.epam.task5004.dao;

import by.epam.task5004.bean.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TreasuresLoaderUtil {

    public static List<Treasure> loadTreasures(Path path) throws IOException {
        List<Treasure> treasures = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)))) {
            while(reader.ready()) {
                String[] treasureStrings = reader.readLine().split(" ");
                switch (treasureStrings[0]) {
                    case "CoinsChest":
                        loadCoinsChest(treasures, treasureStrings);
                        break;
                    case "Gem":
                        loadGem(treasures, treasureStrings);
                        break;
                    case "Decoration":
                        loadDecoration(treasures, treasureStrings);
                        break;
                    case "Tableware":
                        loadTableware(treasures, treasureStrings);
                        break;
                    default:
                        throw new RuntimeException("Exception while loading treasures!");
                }
            }
        }
        return treasures;
    }

    private static void loadCoinsChest(List<Treasure> treasures, String[] treasureStrings) {
        PreciousMetal metal;
        int coinsNumber;
        BigDecimal cost;

        metal = PreciousMetal.valueOf(treasureStrings[1]);
        coinsNumber = Integer.parseInt(treasureStrings[2]);
        cost = BigDecimal.valueOf(Double.parseDouble(treasureStrings[3]));

        treasures.add(new CoinsChest(metal, coinsNumber, cost));
    }

    private static void loadGem(List<Treasure> treasures, String[] treasureStrings) {
        GemType type;
        double carat;
        BigDecimal cost;

        type = GemType.valueOf(treasureStrings[1]);
        carat = Double.parseDouble(treasureStrings[2]);
        cost = BigDecimal.valueOf(Double.parseDouble(treasureStrings[3]));

        treasures.add(new Gem(type, carat, cost));
    }

    private static void loadDecoration(List<Treasure> treasures, String[] treasureStrings) {
        int numberOfMetals;
        int numberOfGems;
        Decoration.DecorationType type;
        double weight;
        PreciousMetal[] metals=null;
        GemType[] gemTypes = null;
        BigDecimal cost;

        numberOfMetals = Integer.parseInt(treasureStrings[1]);
        numberOfGems = Integer.parseInt(treasureStrings[2]);
        type = Decoration.DecorationType.valueOf(treasureStrings[3]);
        weight = Double.parseDouble(treasureStrings[4]);

        if (numberOfMetals > 0) {
            metals = new PreciousMetal[numberOfMetals];
            for (int i = 0; i < numberOfMetals; i++) {
                metals[i] = PreciousMetal.valueOf(treasureStrings[5 + i]);
            }
        }

        if (numberOfGems > 0) {
            gemTypes = new GemType[numberOfGems];
            for (int i = 0; i < numberOfGems; i++) {
                gemTypes[i] = GemType.valueOf(treasureStrings[5 + numberOfMetals + i]);
            }
        }

        cost = BigDecimal.valueOf(Double.parseDouble(treasureStrings[5 + numberOfMetals + numberOfGems]));

        treasures.add(new Decoration(type, weight, metals, gemTypes, cost));
    }

    private static void loadTableware(List<Treasure> treasures, String[] treasureStrings) {
        Tableware.TablewareType type;
        PreciousMetal metal;
        BigDecimal cost;

        type = Tableware.TablewareType.valueOf(treasureStrings[1]);
        metal = PreciousMetal.valueOf(treasureStrings[2]);
        cost = BigDecimal.valueOf(Double.parseDouble(treasureStrings[3]));

        treasures.add(new Tableware(type, metal, cost));
    }
}
