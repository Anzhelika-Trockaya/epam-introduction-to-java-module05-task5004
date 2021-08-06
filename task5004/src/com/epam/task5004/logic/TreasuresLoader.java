package com.epam.task5004.logic;

import com.epam.task5004.treasures.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;

public class TreasuresLoader {
    private Path treasuresPath;

    public TreasuresLoader(Path path) {
        this.treasuresPath = path;
    }

    public ArrayList<Treasure> loadTreasures() throws IOException {
        ArrayList<Treasure> treasures = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(treasuresPath)))) {
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

    private void loadCoinsChest(ArrayList<Treasure> treasures, String[] treasureStrings) {
        PreciousMetal metal = PreciousMetal.valueOf(treasureStrings[1]);
        int coinsNumber = Integer.parseInt(treasureStrings[2]);
        BigDecimal cost = BigDecimal.valueOf(Double.parseDouble(treasureStrings[3]));
        treasures.add(new CoinsChest(metal, coinsNumber, cost));
    }

    private void loadGem(ArrayList<Treasure> treasures, String[] treasureStrings) {
        GemType type = GemType.valueOf(treasureStrings[1]);
        double carat = Double.parseDouble(treasureStrings[2]);
        BigDecimal cost = BigDecimal.valueOf(Double.parseDouble(treasureStrings[3]));
        treasures.add(new Gem(type, carat, cost));
    }

    private void loadDecoration(ArrayList<Treasure> treasures, String[] treasureStrings) {
        int numberOfMetals = Integer.parseInt(treasureStrings[1]);
        int numberOfGems = Integer.parseInt(treasureStrings[2]);
        Decoration.DecorationType type = Decoration.DecorationType.valueOf(treasureStrings[3]);
        double weight = Double.parseDouble(treasureStrings[4]);
        PreciousMetal[] metals = null;
        GemType[] gemTypes = null;
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
        BigDecimal cost = BigDecimal.valueOf(Double.parseDouble(treasureStrings[5 + numberOfMetals + numberOfGems]));
        treasures.add(new Decoration(type, weight, metals, gemTypes, cost));
    }

    private void loadTableware(ArrayList<Treasure> treasures, String[] treasureStrings) {
        Tableware.TablewareType type = Tableware.TablewareType.valueOf(treasureStrings[1]);
        PreciousMetal metal = PreciousMetal.valueOf(treasureStrings[2]);
        BigDecimal cost = BigDecimal.valueOf(Double.parseDouble(treasureStrings[3]));
        treasures.add(new Tableware(type, metal, cost));
    }
}
