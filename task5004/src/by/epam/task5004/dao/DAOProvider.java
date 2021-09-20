package by.epam.task5004.dao;

import by.epam.task5004.dao.impl.file.FileIdDAO;
import by.epam.task5004.dao.impl.file.FileTreasuresDAO;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();
    private TreasuresDAO treasuresDAO;
    private IdDAO idDAO;


    private DAOProvider() {
    }

    public static DAOProvider getInstance() {
        return instance;
    }

    public TreasuresDAO getTreasuresDAO() {
        treasuresDAO = new FileTreasuresDAO();
        return treasuresDAO;
    }

    public IdDAO getIdDAO() {
        if (idDAO != null) {
            return idDAO;
        } else {
            idDAO = new FileIdDAO();
        }

        return idDAO;
    }
}
