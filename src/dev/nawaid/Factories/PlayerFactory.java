package dev.nawaid.Factories;

import dev.nawaid.Models.BotPlayer;
import dev.nawaid.Models.HumanPlayer;

public class PlayerFactory {
    public static HumanPlayer.Builder getHumanPlayer() {
        return HumanPlayer.getBuilder();
    }

    public static BotPlayer.Builder getBotPlayer() {
        return BotPlayer.getBuilder();
    }
}
