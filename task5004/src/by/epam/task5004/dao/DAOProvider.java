package by.epam.task5004.dao;

import by.epam.task5004.dao.impl.file.FileIdDAO;
import by.epam.task5004.dao.impl.file.FileTreasuresDAO;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();
    private final TreasuresDAO treasuresDAO;
    private final IdDAO idDAO;


    private DAOProvider() {
        treasuresDAO = new FileTreasuresDAO();
        idDAO = new FileIdDAO();
    }

    public static DAOProvider getInstance() {
        return instance;
    }

    public TreasuresDAO getTreasuresDAO() {
        return treasuresDAO;
    }

    public IdDAO getIdDAO() {
        return idDAO;
    }
}
