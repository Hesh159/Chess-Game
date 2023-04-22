package com.hession.chessapp.board;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessSquare extends Rectangle {

    private final Color light = Color.BEIGE;
    private final Color dark = Color.BROWN;

    private boolean isOccupied;

    public ChessSquare() {
        this.setWidth(50);
        this.setHeight(50);
    }


    /**
     * Determine if Square is occupied (has a piece on it)
     */
    public boolean isSquareOccupied() {
        return isOccupied;
    }

    /**
     * @param occupationStatus - Whether a square has a piece on it
     *
     * Sets the Squares isOccupied property to occupationStatus
     */
    public void setSquareOccupied(boolean occupationStatus) {
        this.isOccupied = occupationStatus;
    }

    /**
     * @param col - Column of Square
     * @param row - Row of Square
     *
     * Determines and sets colour of Square - on a chessboard if a squares row and column are both odd, or both even numbers,
     * the square is dark. As our grid starts from the top rather than the bottom like a chessboard, the square will be light
     */
    public void setSquareColor(int col, int row) {
        boolean isColEven = (col % 2 == 0);
        boolean isRowEven = (row % 2 == 0);

        if (isRowEven == isColEven) {
            this.setFill(light);
        } else {
            this.setFill(dark);
        }
    }

}
