package com.hession.chessapp.board;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ChessBoardMatrixTest {

    static ChessBoardMatrix chessBoardMatrix;

    @BeforeAll
    static void setup() {
        chessBoardMatrix = new ChessBoardMatrix();
    }

    @Tag("ChessBoardMatrixAddSquareTest")
    @DisplayName("Ensure a Square being added at 1, 1 is placed into the board matrix at 0,0")
    @Test
    void test_addSquareAt_1_1() {
        ChessSquare square = new ChessSquare(1, 1);
        chessBoardMatrix.addSquareToBoardMatrix(square);
        List<List<ChessSquare>> chessBoard = chessBoardMatrix.getChessBoard();
        List<ChessSquare> boardRow = chessBoard.get(0);
        ChessSquare resultSquare = boardRow.get(0);
        assertEquals(square, resultSquare);
    }

    @Tag("ChessBoardMatrixGetSquareTest")
    @DisplayName("Ensure a Square added at 5, 4, can be retrieved from the matrix with appropriate coords")
    @Test
    void test_getSquareAt_5_4() {
        ChessSquare square = new ChessSquare(5, 4);
        chessBoardMatrix.addSquareToBoardMatrix(square);
        ChessSquare resultSquare = chessBoardMatrix.getSquareAtCoords(5, 4);
        assertEquals(square, resultSquare);
    }
}
