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

    @Tag("ChessBoardMatrixGetSquareCoordinateTest")
    @DisplayName("Ensure a Square at 3, 4, returns proper matrix coordinates")
    @Test
    void test_getMatrixCoordinatesOfSquareAt_3_4() {
        ChessSquare square = new ChessSquare(3, 4);
        List<Integer> squareCoordinates = chessBoardMatrix.getSquarePositionInMatrix(square);
        assertEquals(2, squareCoordinates.get(ChessBoardMatrix.ROW_INDEX_OF_COORDINATE_ARRAY));
        assertEquals(3, squareCoordinates.get(ChessBoardMatrix.COL_INDEX_OF_COORDINATE_ARRAY));
    }
}