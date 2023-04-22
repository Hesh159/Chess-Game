package com.hession.chessapp.board;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessSquare extends Rectangle {

    private Color light = Color.BEIGE;
    private Color dark = Color.BROWN;

    private boolean isOccupied;

    public ChessSquare() {
        this.setWidth(50);
        this.setHeight(50);
    }

    public boolean isSquareOccupied() {
        return isOccupied;
    }

    public void setSquareOccupied(boolean occupationStatus) {
        this.isOccupied = occupationStatus;
    }

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
