package dev.nawaid;

import dev.nawaid.Controllers.GameController;
import dev.nawaid.Exceptions.InvalidColumnCountException;
import dev.nawaid.Exceptions.InvalidPlayerCountException;
import dev.nawaid.Exceptions.InvalidRowCountException;
import dev.nawaid.Factories.PlayerFactory;
import dev.nawaid.Models.Game;
import dev.nawaid.Models.User;
import dev.nawaid.Strategies.DefaultWinningStrategy;
import dev.nawaid.Strategies.MediumBotMoveStrategy;

public class Main {

  public static void main(String[] args)
      throws InvalidRowCountException, InvalidPlayerCountException, InvalidColumnCountException {
    Game game =
        Game.getBuilder()
            .addPlayer(
                PlayerFactory.getHumanPlayer()
                    .setUser(new User("nawaid15j95@gmail.com", "Nawaid Ahmad Maroof", 1))
                    .setSymbol('X')
                    .build())
            .addPlayer(
                PlayerFactory.getBotPlayer()
                    .addBotMoveStrategy(new MediumBotMoveStrategy())
                    .build())
            .addWinningStrategy(new DefaultWinningStrategy())
            .setRowCount(3)
            .setColumnCount(3)
            .build();
    GameController.run(game);
    }
}
