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

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("id") && parameterStrings[1].matches("\\d+")) {
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

        for (int i = 0; i < preciousMetals.length; i++) {
            if (PreciousMetal.valueOf(metal) == preciousMetals[i]) {
                return true;
            }
        }

        return false;
    }

    public int parseCoinsNumber(String parameter) throws DAOException {
        int coinsNumber;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("coinsNumber") && parameterStrings[1].matches("[1-9]\\d*")) {
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

        for (int i = 0; i < types.length; i++) {
            if (Decoration.DecorationType.valueOf(type) == types[i]) {
                return true;
            }
        }

        return false;
    }

    public double parseWeight(String parameter) throws DAOException {
        double weight;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("weight") && parameterStrings[1]
                .matches("([1-9]\\d*(\\.\\d{1,3})?)|(\\d+\\.(([1-9]\\d{1,2})|(\\d[1-9]\\d?)|(\\d\\d[1-9])))")) {
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

        parameterStrings=parameter.split("=");

        if(parameterStrings[0].equals("metals") && parameterStrings[1].matches("\\{([A-Z]+)(\\s+[A-Z]+)*}")){

            metals=new ArrayList<>();
            metalsStrings=parameterStrings[1].substring(1,parameterStrings[1].length()-1).split("\\s+");

            for (int i = 0; i < metalsStrings.length; i++) {
                currentMetal=parseMetal("metal="+metalsStrings[i]);
                if(!metals.contains(currentMetal)){
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


        parameterStrings=parameter.split("=");

        if(parameterStrings[0].equals("gemsTypes")){
            if(parameterStrings[1].equals("{}")){
                return new ArrayList<>();
            } else{
                gemsTypes=new ArrayList<>();
                gemsTypesStrings=parameterStrings[1].substring(1,parameterStrings[1].length()-1).split("\\s+");

                for (int i = 0; i < gemsTypesStrings.length; i++) {
                    currentGemType=parseGemType("type="+gemsTypesStrings[i]);
                    if(!gemsTypes.contains(currentGemType)){
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

        parameterStrings=parameter.split("=");

        if(parameterStrings[0].equals("type") && existGemType(parameterStrings[1])){
           type = GemType.valueOf(parameterStrings[1]);
           return type;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    private boolean existGemType(String type) {
        GemType[] types;

        types = GemType.values();

        for (int i = 0; i < types.length; i++) {
            if (GemType.valueOf(type) == types[i]) {
                return true;
            }
        }

        return false;
    }

    public double parseCarat(String parameter) throws DAOException {
        double carat;
        String[] parameterStrings;

        parameterStrings = parameter.split("=");

        if (parameterStrings[0].equals("carat") && parameterStrings[1]
                .matches("([1-9]\\d*(\\.\\d\\d?)?)|(\\d+\\.([1-9]\\d?)|(\\d[1-9]))")) {
            carat = Double.parseDouble(parameterStrings[1]);
            return carat;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    public Tableware.TablewareType parseTablewareType(String parameter) throws DAOException {
        Tableware.TablewareType type;
        String[] parameterStrings;

        parameterStrings=parameter.split("=");

        if(parameterStrings[0].equals("type") && existTablewareType(parameterStrings[1])){
            type = Tableware.TablewareType.valueOf(parameterStrings[1]);
            return type;
        } else {
            throw new DAOException("Incorrect data!");
        }
    }

    private boolean existTablewareType(String type) {
        Tableware.TablewareType[] types;

        types = Tableware.TablewareType.values();

        for (int i = 0; i < types.length; i++) {
            if (Tableware.TablewareType.valueOf(type) == types[i]) {
                return true;
            }
        }

        return false;
    }
}
