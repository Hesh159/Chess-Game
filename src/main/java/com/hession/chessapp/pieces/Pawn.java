package com.hession.chessapp.pieces;

import com.hession.chessapp.board.ChessBoardMatrix;
import com.hession.chessapp.board.ChessSquare;

public class Pawn implements IsPiece {
    ChessSquare currentSquare;
    ChessBoardMatrix chessBoardMatrix;

    public Pawn() {

    }

    @Override
    public ChessSquare getCurrentSquare() {
        return null;
    }

    @Override
    public void setCurrentSquare(ChessSquare square) {

    }
}