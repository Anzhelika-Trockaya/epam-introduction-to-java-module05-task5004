package by.epam.task5004.controller.impl;

import by.epam.task5004.controller.Controller;
import by.epam.task5004.controller.command.Command;
import by.epam.task5004.controller.command.CommandProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureController implements Controller {
    private final CommandProvider provider = new CommandProvider();

    @Override
    public String doAction(String request) {
        Command command;
        String commandName;
        String response;

        commandName = takeCommandName(request);
        command = provider.getCommand(commandName);
        response = command.execute(takeParams(request));

        return response;
    }

    private String takeCommandName(String request) {
        String commandName = "";
        StringBuilder commandNameBuilder;
        char[] charsOfRequest;
        char currentChar;

        if (!request.isEmpty()) {
            commandNameBuilder = new StringBuilder();
            charsOfRequest = request.toCharArray();

            for (char c : charsOfRequest) {
                currentChar = c;

                if (currentChar != ' ') {
                    commandNameBuilder.append(currentChar);
                } else {
                    break;
                }
            }

            commandName = commandNameBuilder.toString();
        }

        return commandName;
    }

    private String[] takeParams(String request) {
        List<String> treasureParams;
        Pattern parametersPattern;
        Matcher parametersMatcher;

        parametersPattern = Pattern.compile("[a-zA-Z]+=(([a-zA-Z0-9.]+)|(\\{[^{]*}))");
        parametersMatcher = parametersPattern.matcher(request);
        treasureParams = new ArrayList<>();

        while (parametersMatcher.find()) {
            treasureParams.add(parametersMatcher.group());
        }

        return treasureParams.toArray(new String[treasureParams.size()]);
    }
}
