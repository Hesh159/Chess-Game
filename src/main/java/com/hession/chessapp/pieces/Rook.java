package com.hession.chessapp.pieces;

import com.hession.chessapp.board.ChessBoardMatrix;
import com.hession.chessapp.board.ChessSquare;

import java.util.ArrayList;
import java.util.List;

public class Rook implements IsPiece {

    ChessSquare currentSquare;
    ChessBoardMatrix chessBoardMatrix;

    public Rook(ChessBoardMatrix chessBoardMatrix) {
        this.chessBoardMatrix = chessBoardMatrix;
    }

    public void setCurrentSquare(ChessSquare square) {
        this.currentSquare = square;
    }

    public ChessSquare getCurrentSquare() {
        return this.currentSquare;
    }
}
