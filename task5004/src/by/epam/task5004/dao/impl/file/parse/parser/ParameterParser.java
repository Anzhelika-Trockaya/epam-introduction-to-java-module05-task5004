package by.epam.task5004.dao.impl.file.parse.parser;

import by.epam.task5004.bean.Decoration;
import by.epam.task5004.bean.GemType;
import by.epam.task5004.bean.PreciousMetal;
import by.epam.task5004.bean.Tableware;
import by.epam.task5004.dao.DAOException;

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

    public int parseId(String parameter) throws DAOException {
        int id;
        String[] parameterStrings;
        String idRegex;

        parameterStrings = parameter.split("=");
        idRegex = "\\d+";

        if (parameterStrings[0].equals("id") && parameterStrings[1].matches(idRegex)) {
            id = Integer.parseInt(parameterStrings[1]);
            return id;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    public PreciousMetal parseMetal(String parameter) throws DAOException {
        PreciousMetal metal;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("metal") && existPreciousMetal(parameterStrings[1])) {
            metal = PreciousMetal.valueOf(parameterStrings[1]);
            return metal;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    private boolean existPreciousMetal(String metal) {
        PreciousMetal[] preciousMetals;

        preciousMetals = PreciousMetal.values();

        for (PreciousMetal preciousMetal : preciousMetals) {
            if (metal.equals(preciousMetal.name())) {
                return true;
            }
        }

        return false;
    }

    public int parseCoinsNumber(String parameter) throws DAOException {
        int coinsNumber;
        String[] parameterStrings;
        String coinsNumberRegex;

        parameterStrings = parameter.split("=");
        coinsNumberRegex = "[1-9]\\d*";

        if (parameterStrings[0].equals("coinsNumber") && parameterStrings[1].matches(coinsNumberRegex)) {
            coinsNumber = Integer.parseInt(parameterStrings[1]);
            return coinsNumber;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    public BigDecimal parseCost(String parameter) throws DAOException {
        BigDecimal cost;
        String[] parameterStrings;
        String costRegex;

        costRegex = "([1-9]\\d*(\\.\\d{1,2})?)|(\\d+\\.(([1-9]\\d?)|(0[1-9])))";
        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("cost") && parameterStrings[1].matches(costRegex)) {
            cost = BigDecimal.valueOf(Double.parseDouble(parameterStrings[1]));
            return cost;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    public Decoration.DecorationType parseDecorationType(String parameter) throws DAOException {
        Decoration.DecorationType type;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("type") && existDecorationType(parameterStrings[1])) {
            type = Decoration.DecorationType.valueOf(parameterStrings[1]);
            return type;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    private boolean existDecorationType(String type) {
        Decoration.DecorationType[] types;

        types = Decoration.DecorationType.values();

        for (Decoration.DecorationType decorationType : types) {
            if (type.equals(decorationType.name())) {
                return true;
            }
        }

        return false;
    }

    public double parseWeight(String parameter) throws DAOException {
        double weight;
        String[] parameterStrings;
        String weightRegex;

        parameterStrings = parameter.split("=");
        weightRegex = "([1-9]\\d*(\\.\\d{1,3})?)|(\\d+\\.(([1-9]\\d{1,2})|(\\d[1-9]\\d?)|(\\d\\d[1-9])))";

        if (parameterStrings[0].equals("weight") && parameterStrings[1].matches(weightRegex)) {
            weight = Double.parseDouble(parameterStrings[1]);
            return weight;
        } else {
            throw new DAOException("Incorrect data!");
        }

    }

    public List<PreciousMetal> parseListOfMetals(String parameter) throws DAOException {
        List<PreciousMetal> metals;
        PreciousMetal currentMetal;
        String[] parameterStrings;
        String[] metalsStrings;
        String metalsListRegex;

        parameterStrings = parameter.split("=");
        metalsListRegex = "\\{([A-Z]+)(\\s+[A-Z]+)*}";

        if (parameterStrings[0].equals("metals") && parameterStrings[1].matches(metalsListRegex)) {

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
            throw new DAOException("Incorrect data!");
        }
    }

    public List<GemType> parseListOfGemsTypes(String parameter) throws DAOException {
        List<GemType> gemsTypes;
        GemType currentGemType;
        String[] parameterStrings;
        String[] gemsTypesStrings;
        String gemsListRegex;


        parameterStrings = parameter.split("=");
        gemsListRegex = "\\{(([A-Z]+)(\\s+[A-Z]+)*)?}";

        if (parameterStrings[0].equals("gemsTypes") && parameterStrings[1].matches(gemsListRegex)) {
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
            throw new DAOException("Incorrect data!");
        }
    }

    public GemType parseGemType(String parameter) throws DAOException {
        GemType type;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("type") && existGemType(parameterStrings[1])) {
            type = GemType.valueOf(parameterStrings[1]);
            return type;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    private boolean existGemType(String type) {
        GemType[] types;

        types = GemType.values();

        for (GemType gemType : types) {
            if (type.equals(gemType.name())) {
                return true;
            }
        }

        return false;
    }

    public double parseCarat(String parameter) throws DAOException {
        double carat;
        String[] parameterStrings;
        String caratRegex;

        parameterStrings = parameter.split("=");
        caratRegex = "([1-9]\\d*(\\.\\d\\d?)?)|(\\d+\\.([1-9]\\d?)|(\\d[1-9]))";

        if (parameterStrings[0].equals("carat") && parameterStrings[1].matches(caratRegex)) {
            carat = Double.parseDouble(parameterStrings[1]);
            return carat;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    public Tableware.TablewareType parseTablewareType(String parameter) throws DAOException {
        Tableware.TablewareType type;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("type") && existTablewareType(parameterStrings[1])) {
            type = Tableware.TablewareType.valueOf(parameterStrings[1]);
            return type;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    private boolean existTablewareType(String type) {
        Tableware.TablewareType[] types;

        types = Tableware.TablewareType.values();

        for (Tableware.TablewareType tablewareType : types) {
            if (type.equals(tablewareType.name())) {
                return true;
            }
        }

        return false;
    }
}
