package com.hession.chessapp.pieces.movement;

import com.hession.chessapp.board.ChessBoard;
import com.hession.chessapp.board.ChessBoardMatrix;
import com.hession.chessapp.board.ChessSquare;
import com.hession.chessapp.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class CanMoveStraightImplementation implements CanMoveStraight {

    private final ChessBoardMatrix chessBoardMatrix;

    public CanMoveStraightImplementation(ChessBoard chessBoard) {
        this.chessBoardMatrix = chessBoard.getChessBoardMatrix();
    }

    @Override
    public List<ChessSquare> getPossibleMoves(Piece chessPiece) {
        List<ChessSquare> possibleVerticalMoves = getPossibleVerticalMoves(chessPiece);
        List<ChessSquare> possibleHorizontalMoves = getPossibleHorizontalMoves(chessPiece);
        List<ChessSquare> allPossibleMoves = new ArrayList<>();
        allPossibleMoves.addAll(possibleHorizontalMoves);
        allPossibleMoves.addAll(possibleVerticalMoves);
        return allPossibleMoves;
    }

    private List<ChessSquare> getPossibleVerticalMoves(Piece chessPiece) {
        return chessBoardMatrix.getUnoccupiedSquaresInSameCol(chessPiece.getCurrentSquare());
    }

    private List<ChessSquare> getPossibleHorizontalMoves(Piece chessPiece) {
        return chessBoardMatrix.getUnoccupiedSquaresInSameRow(chessPiece.getCurrentSquare());
    }
}