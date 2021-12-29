package dev.nawaid.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> cells;
    private int rowCount;
    private int columnCount;

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public void printBoard() {
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.columnCount; j++) {
                System.out.print(this.cells.get(i).get(j).getSymbol().getIdentifier() + " ");
            }
        }
    }
}
