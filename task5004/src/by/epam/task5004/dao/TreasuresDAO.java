package by.epam.task5004.dao;

import by.epam.task5004.bean.Treasure;

import java.util.List;

public interface TreasuresDAO {
    Treasure getNext() throws DAOException;

    void add(Treasure treasure) throws DAOException;

    void deleteIfExist(int id) throws DAOException;

    List<Treasure> getAll() throws DAOException;

}
