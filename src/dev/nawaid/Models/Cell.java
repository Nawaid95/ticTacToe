package dev.nawaid.Models;

import java.util.List;

public class Cell {
    private int x;
    private int y;
    private Symbol symbol;

    public Cell(int x, int y, Symbol symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int[] getCoordinates() {
        return new int[]{this.x, this.y};
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
