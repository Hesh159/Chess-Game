package com.hession.chessapp.board;

import javafx.scene.layout.GridPane;

public class Board {

    private final GridPane chessBoard = new GridPane();

    public Board() {
        buildChessBoard();
    }

    public GridPane getChessBoard() {
        return this.chessBoard;
    }

    private void buildChessBoard() {

        for (int row = 1; row < 9; row++) {
            for (int col = 1; col < 9; col++) {
                ChessSquare chessSquare = new ChessSquare();
                chessSquare.setSquareColor(col, row);
                chessBoard.add(chessSquare, col, row);
            }
        }
    }
}
