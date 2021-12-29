package dev.nawaid.Models;

import dev.nawaid.Exceptions.InvalidPlayerCountException;
import dev.nawaid.Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> playersList = new ArrayList<>();
    private Player currentPlayer;
    private Board board;
    private List<WinningStrategy> winningStrategies = new ArrayList<>();

    private Game() {}

    public List<Player> getPlayersList() {
        return playersList;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void addPlayer(Player player) {
        this.playersList.add(player);
    }

    private void addWinningStrategy(WinningStrategy winStrat) {
        this.winningStrategies.add(winStrat);
    }

    private void setBoard(Board board) {
        this.board = board;
    }

    private void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Game gameObj;

        public Builder() {
            this.gameObj = new Game();
        }

        public Builder addPlayer(Player player) {
            this.gameObj.addPlayer(player);
            return this;
        }

        public Builder addBoard(Board board) {
            this.gameObj.setBoard(board);
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winStrat) {
            this.gameObj.addWinningStrategy(winStrat);
            return this;
        }

        public Game build() throws InvalidPlayerCountException {
            if (this.gameObj.getPlayersList().size() < 2) {
                throw new InvalidPlayerCountException();
            }
            this.gameObj.setCurrentPlayer(this.gameObj.getPlayersList().get(0));
            return this.gameObj;
        }

    }
}
