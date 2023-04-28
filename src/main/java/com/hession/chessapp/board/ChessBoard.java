package com.hession.chessapp.board;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class ChessBoard {
    private final String color = "Black";
    private final GridPane board = new GridPane();
    private StackPane chessSquareContainer;
    private final ChessBoardMatrix boardMatrix;

    public ChessBoard() {
        boardMatrix = new ChessBoardMatrix();
        buildChessBoard();
    }

    public GridPane getBoard() {
        return this.board;
    }

    private void buildChessBoard() {

        for (int row = 1; row < 9; row++) {
            for (int col = 1; col < 9; col++) {
                chessSquareContainer = new StackPane();
                addChessSquareContainerToBoard(row, col);
            }
        }
        if (color == "Black") {
            board.setRotate(180);
        }
    }

    private void addChessSquareContainerToBoard(int row, int col) {
        ChessSquare chessSquare = new ChessSquare(row, col);
        setChessSquareAttributes(chessSquare);
        chessSquareContainer.getChildren().add(chessSquare);
        board.add(chessSquareContainer, col, row);
        boardMatrix.addSquareToBoardMatrix(chessSquare);
    }

    private void setChessSquareAttributes(ChessSquare chessSquare) {
        chessSquare.setSquareColor();
        chessSquare.createAndSetId();
    }

    public ChessSquare getChessSquareAtCoords(int row, int col) {
        return boardMatrix.getSquareAtCoords(row, col);
    }

}