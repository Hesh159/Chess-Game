package com.hession.chessapp.pieces;

import com.hession.chessapp.board.ChessBoardMatrix;
import com.hession.chessapp.board.ChessSquare;
import org.junit.jupiter.api.*;

public class RookTest {

    static Rook rook;
    static ChessBoardMatrix chessBoardMatrix;

    @BeforeAll
    static void init() {
        chessBoardMatrix = new ChessBoardMatrix();
        rook = new Rook(chessBoardMatrix);
    }

    @Nested
    @Tag("StandardMovementTests")
    @DisplayName("Ensure Rook movement works correctly")
    class RookMovementTests {
        @Tag("VerticalMovementTests")
        @DisplayName("Ensure calling getPossibleMoves on a Rook at coordinate 'a2' returns each square on the 'a' column")
        @Test
        void testRookVerticalMovement() {
            ChessSquare rookSquare = new ChessSquare(6, 0);
            rook.setCurrentSquare(rookSquare);
            int currentRookRowPosition = chessBoardMatrix.getMatrixRowOfSquare(rook.getCurrentSquare());

        }
    }
}
