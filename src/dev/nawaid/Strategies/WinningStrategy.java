package dev.nawaid.Strategies;

import dev.nawaid.Models.Board;
import dev.nawaid.Models.Player;

public interface WinningStrategy {
  public Player checkWinner(Player player, Board board);
}
