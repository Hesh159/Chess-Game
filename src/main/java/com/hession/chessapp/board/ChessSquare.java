package com.hession.chessapp.board;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessSquare extends Rectangle {
    private static final int ROW_START_INT = 8;
    private static final int ASCII_LOWER_LETTER_START = 97;
    protected static final Color LIGHT = Color.BEIGE;
    protected static final Color DARK = Color.BROWN;

    private boolean isOccupied;
    private int row;
    private int col;

    public ChessSquare(int row, int col) {
        setRow(row);
        setCol(col);
        this.setWidth(50);
        this.setHeight(50);
    }

    /**
     * Set the row of the ChessSquare
     *
     * @param row - The grid row of the ChessSquare
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Retrieve the row of the ChessSquare
     *
     * @return - The grid row the ChessSquare is placed on
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Set the column of the ChessSquare
     *
     * @param col - The grid column of the ChessSquare
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Retrieve the column of the ChessSquare
     *
     * @return - The grid column the ChessSquare is placed on
     */
    public int getCol() {
        return this.col;
    }


    /**
     * Determine if Square is occupied (has a piece on it)
     */
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Sets the Squares isOccupied property to occupationStatus
     *
     * @param occupationStatus - Whether a square has a piece on it
     */
    public void setOccupied(boolean occupationStatus) {
        this.isOccupied = occupationStatus;
    }

    /**
     * Determines and sets colour of Square
     * <p>
     * On a chessboard if a squares row and column are both odd, or both even numbers,
     * the square is dark. As our grid's (1, 1) coordinate is in the top left, rather than bottom left like a chessboard, a square
     * with odd/even rows and cols should be set to light
     */
    protected void setSquareColor() {
        boolean isColEven = (col % 2 == 0);
        boolean isRowEven = (row % 2 == 0);

        if (isRowEven == isColEven) {
            this.setFill(LIGHT);
        } else {
            this.setFill(DARK);
        }
    }

    /**
     * Create and set the ID of the ChessSquare
     * <p>
     * The id component represents the coordinate of the ChessSquare.
     * The letter coordinate is retrieved from the column of the ChessSquare, while the number coordinate is retrieved
     * from the row of the ChessSquare
     */
    protected void createAndSetId() {
        char letterCoordinate = getLetterCoordinate();
        int numberCoordinate = getNumberCoordinate();
        String letterCoordinateString = Character.toString(letterCoordinate);
        String numberCoordinateString = Integer.toString(numberCoordinate);
        setId(letterCoordinateString + numberCoordinateString);
    }

    /**
     * Determine the letter coordinate of the ChessSquare
     * <p>
     * The value of the column is added to ASCII_LOWER_LETTER_START. The value of ASCII_LOWER_LETTER_START
     * is 97 - the Ascii value of 'a', as the column value ranges from 0 to 7, adding the column to 96 returns the characters between 'a' and 'h' -
     * the letter coordinates of a chessboard
     *
     * @return - The letter coordinate of the ChessSquare, as a char
     */
    protected char getLetterCoordinate() {
        return (char) (col + ASCII_LOWER_LETTER_START);
    }

    /**
     * Determine the number coordinate of the ChessSquare
     * <p>
     * The value of ROW_START_INT is set to 8, taking away the value of row returns the correct row value of the square.
     * This is the case as the top left square of the javafx grid has a coordinate of (1,1), whereas the top left square of a chessboard has a coordinate of (1,8)
     *
     * @return - The number coordinate of the ChessSquare
     */
    protected int getNumberCoordinate() {
        return ROW_START_INT - row;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ChessSquare)) {
            return false;
        }
        return this.row == ((ChessSquare) obj).getRow() && this.col == ((ChessSquare) obj).getCol();
    }
}
