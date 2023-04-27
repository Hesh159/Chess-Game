package com.hession.chessapp.board;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class ChessBoard {
    private final String color = "Black";
    private final GridPane chessBoard = new GridPane();
    private StackPane chessSquareContainer;
    private final ChessBoardArray boardAsArray;

    public ChessBoard() {
        boardAsArray = new ChessBoardArray();
        buildChessBoard();
    }

    public GridPane getChessBoard() {
        return this.chessBoard;
    }

    private void buildChessBoard() {

        for (int row = 1; row < 9; row++) {
            for (int col = 1; col < 9; col++) {
                chessSquareContainer = new StackPane();
                addChessSquareContainerToBoard(row, col);
            }
        }
        if (color == "Black") {
            chessBoard.setRotate(180);
        }
    }

    private void addChessSquareContainerToBoard(int row, int col) {
        ChessSquare chessSquare = new ChessSquare();
        setChessSquareAttributes(chessSquare, row, col);
        chessSquareContainer.getChildren().add(chessSquare);
        chessBoard.add(chessSquareContainer, col, row);
        boardAsArray.addSquareAtCoords(chessSquare, row, col);

        System.out.println("id: " + chessSquare.getId() + " row: " + chessSquare.getRow() + " col: " + chessSquare.getCol());
    }

    private void setChessSquareAttributes(ChessSquare chessSquare, int row, int col) {
        chessSquare.setRow(row);
        chessSquare.setCol(col);
        chessSquare.setSquareColor();
        chessSquare.createAndSetId();
    }

    private void getChessSquareAtCoords(int row, int col) {
        ChessSquare chessSquare = boardAsArray.getSquareAtCoords(row, col);
        System.out.println("Row: " + chessSquare.getRow() + " Col: " + chessSquare.getCol() + " ID: " + chessSquare.getId());
    }

}