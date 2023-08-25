package com.hession.chessapp.movement;

import com.hession.chessapp.board.ChessBoard;
import com.hession.chessapp.board.ChessBoardMatrix;
import com.hession.chessapp.pieces.Piece;
import com.hession.chessapp.pieces.movement.CanMoveStraightImplementation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CanMoveStraightImplementationTest {

    private static CanMoveStraightImplementation canMoveStraightImplementation;

    @Mock
    Piece chessPiece;

    @BeforeAll
    static void init() {
        ChessBoard chessBoard = new ChessBoard();
        this.canMoveStraightImplementation = new CanMoveStraightImplementation(chessBoard);
    }
}
