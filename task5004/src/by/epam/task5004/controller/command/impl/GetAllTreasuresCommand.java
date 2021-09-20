package by.epam.task5004.controller.command.impl;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.controller.command.Command;
import by.epam.task5004.service.ServiceException;
import by.epam.task5004.service.ServiceProvider;
import by.epam.task5004.service.TreasuresService;
import by.epam.task5004.view.UserActionViewer;

import java.util.List;

public class GetAllTreasuresCommand implements Command {
    @Override
    public String execute(String[] params) {
        String response;

        ServiceProvider provider;
        TreasuresService service;

        List<Treasure> treasures;

        try {
            provider = ServiceProvider.getInstance();
            service = provider.getTreasuresService();
            treasures = service.getAllTreasures();
            response = UserActionViewer.getAllTreasuresAnswer(treasures);
        } catch (ServiceException serviceException) {
            response = UserActionViewer.exceptionAnswer(serviceException);
        }

        return response;
    }
}
