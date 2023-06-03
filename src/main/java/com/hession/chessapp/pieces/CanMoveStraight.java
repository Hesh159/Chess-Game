package com.hession.chessapp.pieces;

import com.hession.chessapp.board.ChessSquare;

import java.util.List;

public interface CanMoveStraight extends CanMove {

    public List<ChessSquare> getPossibleVerticalMoves();

    public List<ChessSquare> getPossibleHorizontalMoves();
}
