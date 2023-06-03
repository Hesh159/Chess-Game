package com.hession.chessapp.pieces;

import com.hession.chessapp.board.ChessBoardMatrix;
import com.hession.chessapp.board.ChessSquare;

public class Bishop implements IsPiece {
    ChessSquare currentSquare;
    ChessBoardMatrix chessBoardMatrix;

    public Bishop(ChessBoardMatrix chessBoardMatrix) {
        this.chessBoardMatrix = chessBoardMatrix;
    }

    @Override
    public ChessSquare getCurrentSquare() {
        return currentSquare;
    }

    @Override
    public void setCurrentSquare(ChessSquare square) {
        this.currentSquare = square;
    }
}
