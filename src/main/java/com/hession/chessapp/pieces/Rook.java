package com.hession.chessapp.pieces;

import com.hession.chessapp.board.ChessBoardMatrix;
import com.hession.chessapp.board.ChessSquare;

public class Rook implements Piece {

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
