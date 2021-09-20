package by.epam.task5004.service;

import by.epam.task5004.bean.Treasure;

import java.math.BigDecimal;
import java.util.List;

public interface TreasuresService {
    List<Treasure> getAllTreasures() throws ServiceException;
    Treasure findTheMostExpensive() throws ServiceException;
    List<Treasure> selectTreasuresForAGivenAmount(BigDecimal amount) throws ServiceException;
    void addTreasure(Treasure treasure) throws ServiceException;
    void deleteTreasure(int id) throws ServiceException;

}
