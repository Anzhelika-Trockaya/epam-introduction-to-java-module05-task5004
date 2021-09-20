package by.epam.task5004.service;

import by.epam.task5004.service.impl.TreasuresServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private final TreasuresService treasuresService;

    private ServiceProvider() {
        treasuresService = new TreasuresServiceImpl();
    }

    public static ServiceProvider getInstance() {
        return instance;
    }

    public TreasuresService getTreasuresService() {
        return treasuresService;
    }
}
