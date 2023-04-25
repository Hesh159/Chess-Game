package com.hession.chessapp.board;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ChessSquare extends Rectangle {
    private static final int ROW_START_INT = 9;
    private static final int ASCII_LOWER_LETTER_START = 96;
    private final Color light = Color.BEIGE;
    private final Color dark = Color.BROWN;

    private boolean isOccupied;
    private int row;
    private int col;

    public ChessSquare() {
        this.setWidth(50);
        this.setHeight(50);
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return this.row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return this.col;
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
     * Determines and sets colour of Square - on a chessboard if a squares row and column are both odd, or both even numbers,
     * the square is dark. As our grid starts from the top rather than the bottom like a chessboard, the square will be light
     */
    public void setSquareColor() {
        boolean isColEven = (col % 2 == 0);
        boolean isRowEven = (row % 2 == 0);

        if (isRowEven == isColEven) {
            this.setFill(light);
        } else {
            this.setFill(dark);
        }
    }

    public void createAndSetId() {
        char letterCoordinate = getLetterCoordinate();
        int numberCoordinate = getNumberCoordinate();
        String letterCoordinateString = Character.toString(letterCoordinate);
        String numberCoordinateString = Integer.toString(numberCoordinate);
        setId(letterCoordinateString + numberCoordinateString);
    }

    private char getLetterCoordinate() {
        return (char) (col + ASCII_LOWER_LETTER_START);
    }

    private int getNumberCoordinate() {
        return ROW_START_INT - row;
    }

    public void addNumberToSquareView() {
        int numberCoordinate = getNumberCoordinate();
        Text numberText = new Text(Integer.toString(numberCoordinate));
    }

    public void addLetterToSquareView() {
        char letterCoordinate = getLetterCoordinate();
        Text letterText = new Text(Character.toString(letterCoordinate));
    }
}
