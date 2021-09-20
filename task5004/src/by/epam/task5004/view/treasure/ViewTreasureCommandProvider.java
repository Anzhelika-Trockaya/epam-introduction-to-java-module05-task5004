package by.epam.task5004.view.treasure;

import java.util.HashMap;
import java.util.Map;

public class ViewTreasureCommandProvider {
    private Map<String, ViewTreasureCommand> commands = new HashMap<>();

    public ViewTreasureCommandProvider() {
        commands.put("Tableware", new ViewTablewareCommand());
        commands.put("Gem", new ViewGemCommand());
        commands.put("Decoration", new ViewDecorationCommand());
        commands.put("CoinsChest", new ViewCoinsChestCommand());
    }

    public ViewTreasureCommand getCommand(String commandName) {
        return commands.get(commandName);
    }
}
