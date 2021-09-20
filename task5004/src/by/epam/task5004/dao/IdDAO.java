package by.epam.task5004.dao;

public interface IdDAO {
    int loadCurrentId() throws DAOException;
    void unloadCurrentId(int currentId) throws DAOException;
}
