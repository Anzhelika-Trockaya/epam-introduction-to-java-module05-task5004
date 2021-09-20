package by.epam.task5004.controller.command;

import by.epam.task5004.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands;

    public CommandProvider() {
        commands = new HashMap<>();

        commands.put("mostExpensiveTreasure", new FindTheMostExpensiveCommand());
        commands.put("allTreasures", new GetAllTreasuresCommand());
        commands.put("add", new AddTreasureCommand());
        commands.put("delete", new DeleteTreasureCommand());
        commands.put("treasuresForAmount", new SelectTreasuresForAmountCommand());
    }

    public Command getCommand(String commandName) {
        Command command;
        command = commands.get(commandName);
        return command;
    }
}
