package dev.nawaid.Models;

import dev.nawaid.Strategies.BotMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class BotPlayer extends Player {
    private List<BotMoveStrategy> moveStrategies = new ArrayList<>();

    @Override
    public void makeMove(Board board) {
        for (BotMoveStrategy moveStrategy : this.moveStrategies) {
            moveStrategy.makeMove(board);
        }
    }
}
