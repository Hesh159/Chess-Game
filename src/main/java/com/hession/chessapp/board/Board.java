package com.hession.chessapp.board;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

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
                StackPane chessSquareContainer = new StackPane();
                addChessSquareContainerToBoard(chessSquareContainer, row, col);
            }
        }

        if (color == "Black") {
            chessBoard.setRotate(180);
        }
    }

    private void addChessSquareContainerToBoard(StackPane chessSquareContainer, int row, int col) {
        ChessSquare chessSquare = new ChessSquare();
        setChessSquareAttributes(chessSquare, row, col);
        chessSquareContainer.getChildren().add(chessSquare);
        chessBoard.add(chessSquareContainer, col, row);

        if (col == 1) {
            chessSquare.addNumberToSquareView();
        }
        if (row == 1) {
            chessSquare.addLetterToSquareView();
        }
        System.out.println("id: " + chessSquare.getId() + " row: " + chessSquare.getRow() + " col: " + chessSquare.getCol());
    }

    private void setChessSquareAttributes(ChessSquare chessSquare, int row, int col) {
        chessSquare.setRow(row);
        chessSquare.setCol(col);
        chessSquare.setSquareColor();
        chessSquare.createAndSetId();
    }
}
