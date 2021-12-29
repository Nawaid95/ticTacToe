package dev.nawaid.Models;

import dev.nawaid.Strategies.BotMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class BotPlayer extends Player {
    private List<BotMoveStrategy> moveStrategies = new ArrayList<>();

  private BotPlayer() {}

    @Override
    public void makeMove(Board board) {
        for (BotMoveStrategy moveStrategy : this.moveStrategies) {
            moveStrategy.makeMove(board);
        }
    }

    public static Builder getBuilder() {
        return new Builder();
    }

  @Override
  public String getName() {
    return "BOT";
  }

    public static class Builder {
        private BotPlayer botPlayerObj;

    public Builder() {
      this.botPlayerObj = new BotPlayer();
    }

        public Builder addBotMoveStrategy(BotMoveStrategy botStrat) {
            this.botPlayerObj.moveStrategies.add(botStrat);
            return this;
        }

        public BotPlayer build() {
            return this.botPlayerObj;
        }
    }
}
