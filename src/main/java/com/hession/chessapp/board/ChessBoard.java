package com.hession.chessapp.board;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class ChessBoard {

    private static final int ROW_TO_GRID_TRANSLATE = 1;
    private static final int COL_TO_GRID_TRANSLATE = 1;
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

    public ChessBoardMatrix getChessBoardMatrix() {
        return this.boardMatrix;
    }

    private void buildChessBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
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

        int chessSquareGridRow = row + ROW_TO_GRID_TRANSLATE;
        int chessSquareGridCol = col + COL_TO_GRID_TRANSLATE;
        board.add(chessSquareContainer, chessSquareGridCol, chessSquareGridRow);
        boardMatrix.addSquareToBoardMatrix(chessSquare);
    }

    private void setChessSquareAttributes(ChessSquare chessSquare) {
        chessSquare.setSquareColor();
        chessSquare.createAndSetId();
    }
}