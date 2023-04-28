package com.hession.chessapp.board;

import java.util.ArrayList;
import java.util.List;

public class ChessBoardMatrix {

    private static final int BOARD_SIZE = 8;
    private static final int GRID_TO_ARRAY_TRANSLATE = 1;

    private final List<List<ChessSquare>> chessBoard = new ArrayList<>();

    public ChessBoardMatrix() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            List<ChessSquare> chessBoardRow = new ArrayList<>();
            for (int j = 0; j < BOARD_SIZE; j++) {
                chessBoardRow.add(null);
            }
            chessBoard.add(chessBoardRow);
        }
    }

    public List<List<ChessSquare>> getChessBoard() {
        return this.chessBoard;
    }

    public void addSquareToBoardMatrix(ChessSquare chessSquare) {
        int row = chessSquare.getRow();
        int col = chessSquare.getCol();
        List<ChessSquare> chessBoardArrayRow = chessBoard.get(row - GRID_TO_ARRAY_TRANSLATE);
        chessBoardArrayRow.add(col - GRID_TO_ARRAY_TRANSLATE, chessSquare);
    }

    public ChessSquare getSquareAtCoords(int row, int col) {
        List<ChessSquare> chessBoardArrayRow = chessBoard.get(row - GRID_TO_ARRAY_TRANSLATE);
        return chessBoardArrayRow.get(col - GRID_TO_ARRAY_TRANSLATE);
    }
}
