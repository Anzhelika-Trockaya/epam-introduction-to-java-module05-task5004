package by.epam.task5004.controller.command.impl;

import by.epam.task5004.bean.Treasure;
import by.epam.task5004.controller.command.Command;
import by.epam.task5004.service.ServiceException;
import by.epam.task5004.service.ServiceProvider;
import by.epam.task5004.service.TreasuresService;
import by.epam.task5004.view.UserActionViewer;

import java.math.BigDecimal;
import java.util.List;

public class SelectTreasuresForAmountCommand implements Command {
    @Override
    public String execute(String... params) {
        String response;
        boolean isAmountCorrect;

        ServiceProvider provider;
        TreasuresService service;

        BigDecimal amount;
        String amountRegex;
        List<Treasure> treasuresForAmount;

        amountRegex = "amount=(([1-9]\\d*(\\.\\d{1,2})?)|(\\d+\\.(([1-9]\\d?)|(0[1-9])))|([1-9]\\.\\d*E[1-9]))";

        try {
            if (params.length == 1 && params[0].matches(amountRegex)) {
                isAmountCorrect = true;
                amount = BigDecimal.valueOf(Double.parseDouble(params[0].substring(7)));

                provider = ServiceProvider.getInstance();
                service = provider.getTreasuresService();

                treasuresForAmount = service.selectTreasuresForAGivenAmount(amount);
            } else {
                isAmountCorrect = false;
                treasuresForAmount = null;
            }

            response = UserActionViewer.treasuresForAGivenAmountAnswer(isAmountCorrect, treasuresForAmount);

        } catch (ServiceException serviceException) {
            response = UserActionViewer.exceptionAnswer(serviceException);
        }
        return response;
    }
}
