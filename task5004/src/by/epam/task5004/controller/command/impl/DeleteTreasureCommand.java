package by.epam.task5004.controller.command.impl;

import by.epam.task5004.controller.command.Command;
import by.epam.task5004.service.ServiceException;
import by.epam.task5004.service.ServiceProvider;
import by.epam.task5004.service.TreasuresService;
import by.epam.task5004.view.UserActionViewer;

public class DeleteTreasureCommand implements Command {
    @Override
    public String execute(String[] params) {
        String response;
        String[] paramId;
        boolean isCorrectId;

        ServiceProvider serviceProvider;
        TreasuresService service;

        int id;

        serviceProvider = ServiceProvider.getInstance();
        service = serviceProvider.getTreasuresService();

        paramId = params[0].split("=");

        try {
            if (paramId[0].equalsIgnoreCase("id") && paramId[1].matches("[1-9][0-9]*")) {
                isCorrectId=true;
                id = Integer.parseInt(paramId[1]);
                service.deleteTreasure(id);
            } else {
                isCorrectId=false;
            }
            response = UserActionViewer.deleteAnswer(isCorrectId);
        } catch (ServiceException serviceException) {
            response = UserActionViewer.exceptionAnswer(serviceException);
        }

        return response;
    }
}
