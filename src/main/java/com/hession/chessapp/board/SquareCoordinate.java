package com.hession.chessapp.board;

public class SquareCoordinate {

    int row;
    int col;

    public SquareCoordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public SquareCoordinate(ChessSquare square) {
        this.row = square.getRow();
        this.col = square.getCol();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}