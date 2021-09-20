package by.epam.task5004.controller.command.impl.parse.command;

import by.epam.task5004.controller.command.impl.parse.ParseException;

import java.util.HashMap;
import java.util.Map;

public class ParseTreasureCommandProvider {
    private Map<String, ParseTreasureCommand> commands=new HashMap<>();

    public ParseTreasureCommandProvider(){
        commands.put("Tableware", new ParseTablewareCommand());
        commands.put("Gem", new ParseGemCommand());
        commands.put("Decoration", new ParseDecorationCommand());
        commands.put("CoinsChest", new ParseCoinsChestCommand());
    }

    public ParseTreasureCommand getCommand(String commandName) throws ParseException {
        if(commands.containsKey(commandName)) {
            return commands.get(commandName);
        } else{
            throw new ParseException("Incorrect name of treasure!");
        }
    }

}
