package com.hession.chessapp.board;

import javafx.scene.layout.GridPane;

public class Board {
    private final String color = "Black";
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
                addChessSquare(chessSquare, row, col);

                if (col == 1) {
                    chessSquare.addNumberToSquareView();
                }

                if (row == 1) {
                    chessSquare.addLetterToSquareView();
                }
            }
        }

        if (color == "Black") {
            chessBoard.setRotate(180);
        }
    }

    private void addChessSquare(ChessSquare chessSquare, int row, int col) {
        chessSquare.setRow(row);
        chessSquare.setCol(col);
        chessSquare.setSquareColor();
        chessSquare.createAndSetId();
        chessBoard.add(chessSquare, col, row);

        System.out.println("id: " + chessSquare.getId() + " row: " + chessSquare.getRow() + " col: " + chessSquare.getCol());
    }
}
