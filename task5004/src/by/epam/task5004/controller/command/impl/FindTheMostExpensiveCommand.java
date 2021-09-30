package by.epam.task5004.controller.command.impl;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.controller.command.Command;
import by.epam.task5004.service.ServiceException;
import by.epam.task5004.service.ServiceProvider;
import by.epam.task5004.service.TreasuresService;
import by.epam.task5004.view.UserActionViewer;

public class FindTheMostExpensiveCommand implements Command {
    @Override
    public String execute(String... params) {
        String response;
        ServiceProvider provider;
        TreasuresService service;
        Treasure mostExpensive;

        try {
            provider = ServiceProvider.getInstance();
            service = provider.getTreasuresService();
            mostExpensive = service.findTheMostExpensive();
            response = UserActionViewer.theMostExpensiveTreasureAnswer(mostExpensive);

        } catch (ServiceException serviceException) {
            response = UserActionViewer.exceptionAnswer(serviceException);
        }

        return response;
    }
}
