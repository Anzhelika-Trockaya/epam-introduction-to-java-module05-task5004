package by.epam.task5004.dao.impl.file.string;

import java.util.HashMap;
import java.util.Map;

public class TreasureToStringCommandProvider {
    private Map<String, TreasureToStringCommand> commands=new HashMap<>();

    public TreasureToStringCommandProvider(){
        commands.put("Tableware", new TablewareToStringCommand());
        commands.put("Gem", new GemToStringCommand());
        commands.put("Decoration", new DecorationToStringCommand());
        commands.put("CoinsChest", new CoinsChestToStringCommand());
    }

    public TreasureToStringCommand getCommand(String commandName){
        return commands.get(commandName);
    }
}
