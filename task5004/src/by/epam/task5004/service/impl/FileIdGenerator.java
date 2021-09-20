package by.epam.task5004.service.impl;

import by.epam.task5004.dao.DAOException;
import by.epam.task5004.dao.DAOProvider;
import by.epam.task5004.dao.IdDAO;
import by.epam.task5004.service.IdGenerator;
import by.epam.task5004.service.ServiceException;

public class FileIdGenerator implements IdGenerator {
    private static final DAOProvider provider = DAOProvider.getInstance();

    public FileIdGenerator() {
    }

    public int getNext() throws ServiceException {
        int currentId;
        int nextId;
        IdDAO dao;

        dao = provider.getIdDAO();
        try {
            currentId = dao.loadCurrentId();
            nextId = currentId + 1;
            dao.unloadCurrentId(nextId);
        } catch (DAOException daoException) {
            throw new ServiceException(daoException);
        }

        return nextId;
    }


}
