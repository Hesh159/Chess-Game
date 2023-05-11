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

    protected void addSquareToBoardMatrix(ChessSquare chessSquare) {
        int row = chessSquare.getRow();
        int col = chessSquare.getCol();
        List<ChessSquare> chessBoardArrayRow = boardMatrix.get(row);
        chessBoardArrayRow.add(col, chessSquare);
    }

    public ChessSquare getSquareAtCoords(int row, int col) {
        List<ChessSquare> chessBoardArrayRow = boardMatrix.get(row);
        return chessBoardArrayRow.get(col);
    }

    public void setSquareOccupiedStatusAtCoords(int row, int col, boolean occupationStatus) {
        ChessSquare square = getSquareAtCoords(row, col);
        square.setOccupied(occupationStatus);
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

    public List<ChessSquare> getUnoccupiedSquaresInSameCol(ChessSquare square) {
        return getUnoccupiedSquares(square, false);
    }

    public List<ChessSquare> getUnoccupiedSquaresInSameRow(ChessSquare square) {
        return getUnoccupiedSquares(square, true);
    }

    protected List<ChessSquare> getUnoccupiedSquares(ChessSquare square, boolean checkingRow) {
        int squareRow = square.getRow();
        int squareCol = square.getCol();
        List<ChessSquare> unoccupiedSquares = new ArrayList<>();
        int testCoordinate = (checkingRow) ? squareCol : squareRow;

        for (int testCord = testCoordinate - 1; testCord >= 0; testCord--) {
            ChessSquare squareAtCurrentCoordinate = (checkingRow) ? getSquareAtCoords(squareRow, testCord) : getSquareAtCoords(testCord, squareCol);
            if (squareAtCurrentCoordinate.isOccupied()) {
                break;
            }
            unoccupiedSquares.add(squareAtCurrentCoordinate);
        }

        for (int testCord = testCoordinate + 1; testCord < BOARD_SIZE; testCord++) {
            ChessSquare squareAtCurrentCoordinate = (checkingRow) ? getSquareAtCoords(squareRow, testCord) : getSquareAtCoords(testCord, squareCol);
            if (squareAtCurrentCoordinate.isOccupied()) {
                break;
            }
            unoccupiedSquares.add(squareAtCurrentCoordinate);
        }
        return unoccupiedSquares;
    }
}