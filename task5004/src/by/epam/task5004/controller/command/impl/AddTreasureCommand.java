package by.epam.task5004.controller.command.impl;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.controller.command.Command;
import by.epam.task5004.controller.command.impl.parse.ParseException;
import by.epam.task5004.controller.command.impl.parse.parser.TreasureParser;
import by.epam.task5004.service.ServiceException;
import by.epam.task5004.service.ServiceProvider;
import by.epam.task5004.service.TreasuresService;
import by.epam.task5004.view.UserActionViewer;

public class AddTreasureCommand implements Command {
    @Override
    public String execute(String[] params) {
        String response;
        ServiceProvider serviceProvider;
        TreasuresService service;
        Treasure treasure;
        boolean areParamsCorrect;
        TreasureParser treasureParser;

        try {
            serviceProvider = ServiceProvider.getInstance();
            service = serviceProvider.getTreasuresService();

            treasureParser = TreasureParser.getInstance();

            treasure = treasureParser.parse(params);
            areParamsCorrect = true;
            service.addTreasure(treasure);

        } catch (ServiceException serviceException) {
            response = UserActionViewer.exceptionAnswer(serviceException);
            return response;
        } catch (ParseException e) {
            areParamsCorrect = false;
        }

        response = UserActionViewer.addingAnswer(areParamsCorrect);

        return response;
    }
}
