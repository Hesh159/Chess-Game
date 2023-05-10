package com.hession.chessapp.board;

import java.util.ArrayList;
import java.util.List;

public class ChessBoardMatrix {

    private static final int BOARD_SIZE = 8;
    public static final int ROW_INDEX_OF_COORDINATE_ARRAY = 0;
    public static final int COL_INDEX_OF_COORDINATE_ARRAY = 1;

    private final List<List<ChessSquare>> boardMatrix = new ArrayList<>();

    public ChessBoardMatrix() {
        buildChessBoardMatrix();
    }

    public List<List<ChessSquare>> getBoardMatrix() {
        return this.boardMatrix;
    }

    public void buildChessBoardMatrix() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            List<ChessSquare> chessBoardRow = new ArrayList<>();
            for (int j = 0; j < BOARD_SIZE; j++) {
                chessBoardRow.add(null);
            }
            boardMatrix.add(chessBoardRow);
        }
    }

    public void addSquareToBoardMatrix(ChessSquare chessSquare) {
        int row = chessSquare.getRow();
        int col = chessSquare.getCol();
        List<ChessSquare> chessBoardArrayRow = boardMatrix.get(row);
        chessBoardArrayRow.add(col, chessSquare);
    }

    public ChessSquare getSquareAtCoords(int row, int col) {
        List<ChessSquare> chessBoardArrayRow = boardMatrix.get(row);
        return chessBoardArrayRow.get(col);
    }

    public List<Integer> getSquarePositionInMatrix(ChessSquare square) {
        List<Integer> squareCoordinates = new ArrayList<>();
        squareCoordinates.add(getMatrixRowOfSquare(square));
        squareCoordinates.add(getMatrixColOfSquare(square));
        return squareCoordinates;
    }

    public int getMatrixRowOfSquare(ChessSquare square) {
        return square.getRow();
    }

    public int getMatrixColOfSquare(ChessSquare square) {
        return square.getCol();
    }

    /*
    public List<BoardCoordinate> getUnoccupiedCoordinatesInSameCol(ChessSquare square) {
        int squareRow = square.getRow();
        int squareCol = square.getCol();
        List<BoardCoordinate> unoccupiedCoordinates = new ArrayList<>();
        for (int testCol = squareCol - 1; testCol >= 0; testCol--) {
            //if (getSquareAtCoords(squareRow, squareCol).isOccupied()) {
                //break;
            //}
            unoccupiedCoordinates.add(new BoardCoordinate(squareRow, testCol));
        }
        for (int testCol = squareCol + 1; testCol < BOARD_SIZE; testCol++) {
            //if (getSquareAtCoords(squareRow, squareCol).isOccupied()) {
                //break;
            //}
            unoccupiedCoordinates.add(new BoardCoordinate(squareRow, testCol));
        }
        return unoccupiedCoordinates;
    }
     */
}