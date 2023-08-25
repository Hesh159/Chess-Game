package com.hession.chessapp.pieces.movement;

import com.hession.chessapp.board.ChessSquare;
import com.hession.chessapp.pieces.Piece;

import java.util.List;

public interface CanMove {

    List<ChessSquare> getPossibleMoves(Piece chessPiece);
}
