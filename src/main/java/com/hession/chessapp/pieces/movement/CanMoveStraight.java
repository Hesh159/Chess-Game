package com.hession.chessapp.pieces.movement;

import com.hession.chessapp.board.ChessSquare;
import com.hession.chessapp.pieces.movement.CanMove;

import java.util.List;

public interface CanMoveStraight extends CanMove {

    public List<ChessSquare> getPossibleVerticalMoves();

    public List<ChessSquare> getPossibleHorizontalMoves();
}
