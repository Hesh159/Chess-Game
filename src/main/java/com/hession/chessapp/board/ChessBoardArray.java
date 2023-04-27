package com.hession.chessapp.board;

import java.util.ArrayList;
import java.util.List;

public class ChessBoardArray {

    private static final int BOARD_SIZE = 8;
    private static final int GRID_TO_ARRAY_TRANSLATE = 1;

    private final List<List<ChessSquare>> chessBoardAsArray = new ArrayList<>(BOARD_SIZE);

    public ChessBoardArray() {
        for (int i = 0; i < 9; i++) {
            List<ChessSquare> chessBoardRow = new ArrayList<>(BOARD_SIZE);
            chessBoardAsArray.add(chessBoardRow);
        }
    }

    public List<List<ChessSquare>> getChessBoardAsArray() {
        return this.chessBoardAsArray;
    }

    public void addSquareAtCoords(ChessSquare chessSquare, int row, int col) {
        List<ChessSquare> chessBoardArrayRow = chessBoardAsArray.get(row - GRID_TO_ARRAY_TRANSLATE);
        chessBoardArrayRow.add(col - GRID_TO_ARRAY_TRANSLATE, chessSquare);
    }

    public ChessSquare getSquareAtCoords(int row, int col) {
        List<ChessSquare> chessBoardArrayRow = chessBoardAsArray.get(row - GRID_TO_ARRAY_TRANSLATE);
        return chessBoardArrayRow.get(col - GRID_TO_ARRAY_TRANSLATE);
    }
}
