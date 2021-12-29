package dev.nawaid.Models;

import dev.nawaid.Exceptions.InvalidColumnCountException;
import dev.nawaid.Exceptions.InvalidPlayerCountException;
import dev.nawaid.Exceptions.InvalidRowCountException;
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
        private int rowCount;
        private int columnCount;

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

        public Builder setRowCount(int rowCount) {
            this.rowCount = rowCount;
            return this;
        }

        public Builder setColumnCount(int columnCount) {
            this.columnCount = columnCount;
            return this;
        }

        public Game build() throws InvalidPlayerCountException, InvalidRowCountException, InvalidColumnCountException {
            if (this.rowCount < 1) {
                throw new InvalidRowCountException();
            }
            if (this.columnCount < 1) {
                throw new InvalidColumnCountException();
            }
            if (this.gameObj.getPlayersList().size() < 2) {
                throw new InvalidPlayerCountException();
            }
            Board board = new Board();
            board.setRowCount(this.rowCount);
            board.setColumnCount(this.columnCount);
            List<List<Cell>> cells = new ArrayList<>();
            for (int i = 0; i < this.rowCount; i++) {
                cells.add(new ArrayList<>());
                Symbol symbol = new Symbol();
                symbol.setIdentifier('_');
                for (int j = 0; j < this.columnCount; j++) {
                    Cell cell = new Cell();
                    cell.setX(i);
                    cell.setY(j);
                    cell.setSymbol(symbol);
                    cells.get(i).add(cell);
                }
            }
            board.setCells(cells);
            this.gameObj.setBoard(board);
            this.gameObj.setCurrentPlayer(this.gameObj.getPlayersList().get(0));
            return this.gameObj;
        }

    }
}
