package com.hession.chessapp.pieces.movement;

import com.hession.chessapp.board.ChessBoard;
import com.hession.chessapp.board.ChessBoardMatrix;
import com.hession.chessapp.board.ChessSquare;
import com.hession.chessapp.pieces.movement.CanMoveStraight;

import java.util.List;

public class CanMoveStraightImplementation implements CanMoveStraight {

    private ChessBoard chessBoard;
    private ChessBoardMatrix chessBoardMatrix;
    private CanMoveStraight piece;

    public CanMoveStraightImplementation(ChessBoard chessBoard, CanMoveStraight piece) {
        this.chessBoard = chessBoard;
        this.chessBoardMatrix = chessBoard.getChessBoardMatrix();
        this.piece = piece;
    }

    @Override
    public List<ChessSquare> getPossibleMoves() {
        return null;
    }

    @Override
    public List<ChessSquare> getPossibleVerticalMoves() {
        //return chessBoardMatrix.getUnoccupiedSquaresInSameCol();
        return null;
    }

    @Override
    public List<ChessSquare> getPossibleHorizontalMoves() {
        return null;
    }
}
