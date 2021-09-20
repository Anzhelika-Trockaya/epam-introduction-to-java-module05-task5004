package by.epam.task5004.service.impl;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.dao.DAOException;
import by.epam.task5004.dao.DAOProvider;
import by.epam.task5004.dao.TreasuresDAO;
import by.epam.task5004.service.IdGenerator;
import by.epam.task5004.service.ServiceException;
import by.epam.task5004.service.TreasuresService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TreasuresServiceImpl implements TreasuresService {
    private static final DAOProvider provider = DAOProvider.getInstance();

    public TreasuresServiceImpl() {
    }

    public Treasure findTheMostExpensive() throws ServiceException {
        Treasure mustExpensiveTreasure;
        BigDecimal maxCost;

        TreasuresDAO dao;
        Treasure currentTreasure;
        BigDecimal currentTreasureCost;

        dao = provider.getTreasuresDAO();
        maxCost = BigDecimal.ZERO;
        mustExpensiveTreasure = null;

        try {
            currentTreasure = dao.getNext();
            while (currentTreasure != null) {
                currentTreasureCost = currentTreasure.getCost();

                if (currentTreasureCost.compareTo(maxCost) > 0) {
                    maxCost = currentTreasureCost;
                    mustExpensiveTreasure = currentTreasure;
                }

                currentTreasure = dao.getNext();
            }

            return mustExpensiveTreasure;
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
    }

    public List<Treasure> getAllTreasures() throws ServiceException {
        List<Treasure> allTreasures;
        Treasure currentTreasure;
        TreasuresDAO dao;

        allTreasures = new ArrayList<>();
        dao = provider.getTreasuresDAO();

        try {
            currentTreasure = dao.getNext();

            while (currentTreasure != null) {
                allTreasures.add(currentTreasure);
                currentTreasure = dao.getNext();
            }

            return allTreasures;
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
    }

    public List<Treasure> selectTreasuresForAGivenAmount(BigDecimal amount) throws ServiceException {
        List<Treasure> lowerValueTreasures;
        List<Treasure> selectedTreasures;
        BigDecimal selectedTreasuresAmount;


        lowerValueTreasures = getAllTreasures()
                .stream()
                .filter(treasure -> (amount.compareTo(treasure.getCost()) >= 0))
                .sorted(Comparator.comparing(Treasure::getCost).reversed())
                .collect(Collectors.toList());

        if (!lowerValueTreasures.isEmpty()) {

            selectedTreasures = new ArrayList<>();
            selectedTreasures.add(lowerValueTreasures.get(0));

            if (amount.compareTo(lowerValueTreasures.get(0).getCost()) == 0) {
                return selectedTreasures;
            }

            do {
                selectedTreasures = fillListOfTreasuresToAmount(selectedTreasures, lowerValueTreasures, amount);
                selectedTreasuresAmount = countAmountOfTreasures(selectedTreasures);

                if (amount.compareTo(selectedTreasuresAmount) == 0) {
                    return selectedTreasures;
                }

                selectedTreasures = moveLastElement(selectedTreasures, lowerValueTreasures);

            } while (selectedTreasures != null);

        }

        return new ArrayList<>();
    }

    private BigDecimal countAmountOfTreasures(List<Treasure> treasures) {
        BigDecimal resultAmount;

        resultAmount = BigDecimal.ZERO;

        for (Treasure treasure : treasures) {
            resultAmount = resultAmount.add(treasure.getCost());
        }

        return resultAmount;
    }

    private List<Treasure> fillListOfTreasuresToAmount(List<Treasure> selectedTreasures
            , List<Treasure> treasures, BigDecimal amount) {

        int lastElementIndexInTreasures;
        BigDecimal selectedTreasuresAmount;
        BigDecimal tempAmount;

        lastElementIndexInTreasures = treasures.indexOf(selectedTreasures.get(selectedTreasures.size() - 1));
        selectedTreasuresAmount = countAmountOfTreasures(selectedTreasures);

        for (int i = lastElementIndexInTreasures + 1; i < treasures.size(); i++) {
            tempAmount = selectedTreasuresAmount.add(treasures.get(i).getCost());

            if (amount.compareTo(tempAmount) >= 0) {
                selectedTreasures.add(treasures.get(i));
                selectedTreasuresAmount = tempAmount;
            }
        }

        return selectedTreasures;
    }

    private List<Treasure> moveLastElement(List<Treasure> selectedTreasures, List<Treasure> treasures) {
        int indexOfElementInTreasures;
        int lastIndexOfTreasures;

        lastIndexOfTreasures = treasures.size() - 1;

        for (int i = selectedTreasures.size() - 1; i >= 0; i--) {
            indexOfElementInTreasures = treasures.indexOf(selectedTreasures.get(i));

            if (indexOfElementInTreasures < lastIndexOfTreasures - 1 - (selectedTreasures.size() - 1 - i)) {
                selectedTreasures.set(i, treasures.get(indexOfElementInTreasures + 1));
                return selectedTreasures;
            }
        }

        return null;
    }


    @Override
    public void addTreasure(Treasure treasure) throws ServiceException {
        TreasuresDAO dao;
        IdGenerator idGenerator;

        dao = provider.getTreasuresDAO();
        idGenerator = new FileIdGenerator();

        try {
            treasure.setId(idGenerator.getNext());
            dao.add(treasure);
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public void deleteTreasure(int id) throws ServiceException {
        TreasuresDAO dao;

        dao = provider.getTreasuresDAO();

        try {
            dao.deleteIfExist(id);
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
    }
}
