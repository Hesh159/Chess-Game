package com.hession.chessapp.pieces;

import com.hession.chessapp.board.ChessSquare;

import java.util.List;

public interface CanMove {

    List<ChessSquare> getPossibleMoves();
}
