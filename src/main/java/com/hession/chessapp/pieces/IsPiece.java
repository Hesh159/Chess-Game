package com.hession.chessapp.pieces;

import com.hession.chessapp.board.ChessSquare;

public interface IsPiece {

    ChessSquare getCurrentSquare();

    void setCurrentSquare(ChessSquare square);
}
