package by.epam.task5004.controller.command.impl.parse.parser;

import by.epam.task5004.bean.Decoration;
import by.epam.task5004.bean.GemType;
import by.epam.task5004.bean.PreciousMetal;
import by.epam.task5004.bean.Tableware;
import by.epam.task5004.controller.command.impl.parse.ParseException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParameterParser {
    private static final ParameterParser instance = new ParameterParser();

    private ParameterParser() {
    }

    public static ParameterParser getInstance() {
        return instance;
    }

    public PreciousMetal parseMetal(String parameter) throws ParseException {
        PreciousMetal metal;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("metal") && existPreciousMetal(parameterStrings[1])) {
            metal = PreciousMetal.valueOf(parameterStrings[1]);
            return metal;
        } else {
            throw new ParseException("Incorrect data of treasure params!");
        }
    }

    private boolean existPreciousMetal(String metal) {
        PreciousMetal[] preciousMetals;

        preciousMetals = PreciousMetal.values();

        for (PreciousMetal preciousMetal : preciousMetals) {
            if (PreciousMetal.valueOf(metal) == preciousMetal) {
                return true;
            }
        }

        return false;
    }

    public int parseCoinsNumber(String parameter) throws ParseException {
        int coinsNumber;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("coinsNumber") && parameterStrings[1].matches("[1-9]\\d*")) {
            coinsNumber = Integer.parseInt(parameterStrings[1]);
            return coinsNumber;
        } else {
            throw new ParseException("Incorrect data of treasure params!");
        }
    }

    public BigDecimal parseCost(String parameter) throws ParseException {
        BigDecimal cost;
        String[] parameterStrings;
        String costRegex;

        costRegex = "([1-9]\\d*(\\.\\d{1,2})?)|(\\d+\\.(([1-9]\\d?)|(0[1-9])))";
        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("cost") && parameterStrings[1].matches(costRegex)) {
            cost = BigDecimal.valueOf(Double.parseDouble(parameterStrings[1]));
            return cost;
        } else {
            throw new ParseException("Incorrect data of treasure params!");
        }
    }

    public Decoration.DecorationType parseDecorationType(String parameter) throws ParseException {
        Decoration.DecorationType type;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("type") && existDecorationType(parameterStrings[1])) {
            type = Decoration.DecorationType.valueOf(parameterStrings[1]);
            return type;
        } else {
            throw new ParseException("Incorrect data of treasure params!");
        }
    }

    private boolean existDecorationType(String type) {
        Decoration.DecorationType[] types;

        types = Decoration.DecorationType.values();

        for (Decoration.DecorationType decorationType : types) {
            if (Decoration.DecorationType.valueOf(type) == decorationType) {
                return true;
            }
        }

        return false;
    }

    public double parseWeight(String parameter) throws ParseException {
        double weight;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("weight") && parameterStrings[1]
                .matches("([1-9]\\d*(\\.\\d{1,3})?)|(\\d+\\.(([1-9]\\d{1,2})|(\\d[1-9]\\d?)|(\\d\\d[1-9])))")) {
            weight = Double.parseDouble(parameterStrings[1]);
            return weight;
        } else {
            throw new ParseException("Incorrect data of treasure params!");
        }

    }

    public List<PreciousMetal> parseListOfMetals(String parameter) throws ParseException {
        List<PreciousMetal> metals;
        PreciousMetal currentMetal;
        String[] parameterStrings;
        String[] metalsStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("metals") && parameterStrings[1].matches("\\{([A-Z]+)(\\s+[A-Z]+)*}")) {

            metals = new ArrayList<>();
            metalsStrings = parameterStrings[1].substring(1, parameterStrings[1].length() - 1).split("\\s+");

            for (String metalsString : metalsStrings) {
                currentMetal = parseMetal("metal=" + metalsString);
                if (!metals.contains(currentMetal)) {
                    metals.add(currentMetal);
                }
            }

            return metals;

        } else {
            throw new ParseException("Incorrect data of treasure params!");
        }
    }

    public List<GemType> parseListOfGemsTypes(String parameter) throws ParseException {
        List<GemType> gemsTypes;
        GemType currentGemType;
        String[] parameterStrings;
        String[] gemsTypesStrings;


        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("gemsTypes")) {
            if (parameterStrings[1].equals("{}")) {
                return new ArrayList<>();
            } else {
                gemsTypes = new ArrayList<>();
                gemsTypesStrings = parameterStrings[1].substring(1, parameterStrings[1].length() - 1).split("\\s+");

                for (String gemsTypesString : gemsTypesStrings) {
                    currentGemType = parseGemType("type=" + gemsTypesString);
                    if (!gemsTypes.contains(currentGemType)) {
                        gemsTypes.add(currentGemType);
                    }
                }

                return gemsTypes;
            }
        } else {
            throw new ParseException("Incorrect data of treasure params!");
        }
    }

    public GemType parseGemType(String parameter) throws ParseException {
        GemType type;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("type") && existGemType(parameterStrings[1])) {
            type = GemType.valueOf(parameterStrings[1]);
            return type;
        } else {
            throw new ParseException("Incorrect data of treasure params!");
        }
    }

    private boolean existGemType(String type) {
        GemType[] types;

        types = GemType.values();

        for (GemType gemType : types) {
            if (GemType.valueOf(type) == gemType) {
                return true;
            }
        }

        return false;
    }

    public double parseCarat(String parameter) throws ParseException {
        double carat;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("carat") && parameterStrings[1]
                .matches("([1-9]\\d*(\\.\\d\\d?)?)|(\\d+\\.([1-9]\\d?)|(\\d[1-9]))")) {
            carat = Double.parseDouble(parameterStrings[1]);
            return carat;
        } else {
            throw new ParseException("Incorrect data of treasure params!");
        }
    }

    public Tableware.TablewareType parseTablewareType(String parameter) throws ParseException {
        Tableware.TablewareType type;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("type") && existTablewareType(parameterStrings[1])) {
            type = Tableware.TablewareType.valueOf(parameterStrings[1]);
            return type;
        } else {
            throw new ParseException("Incorrect data of treasure params!");
        }
    }

    private boolean existTablewareType(String type) {
        Tableware.TablewareType[] types;

        types = Tableware.TablewareType.values();

        for (Tableware.TablewareType tablewareType : types) {
            if (Tableware.TablewareType.valueOf(type) == tablewareType) {
                return true;
            }
        }

        return false;
    }
}
