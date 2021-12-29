package dev.nawaid.Controllers;

import dev.nawaid.Models.Game;

public class GameController {
  public static void run(Game game) {
    game.printPlayers();
    game.printBoard();
  }
}
