package com.hession.chessapp.board;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ChessBoardMatrixTest {

    static ChessBoardMatrix chessBoardMatrix;
    static ChessBoard chessBoard;

    @BeforeAll
    static void setup() {
        chessBoardMatrix = new ChessBoardMatrix();
        chessBoard = new ChessBoard();
    }

    @Tag("AddSquareTest")
    @DisplayName("Ensure a Square being added at 0, 0 is placed into the board matrix at 0,0")
    @Test
    void test_addSquareAt_0_0() {
        ChessSquare square = new ChessSquare(0, 0);
        chessBoardMatrix.addSquareToBoardMatrix(square);
        List<List<ChessSquare>> chessBoard = chessBoardMatrix.getBoardMatrix();
        List<ChessSquare> boardRow = chessBoard.get(0);
        ChessSquare resultSquare = boardRow.get(0);
        assertEquals(square, resultSquare);
    }

    @Tag("GetSquareTest")
    @DisplayName("Ensure a Square added at 5, 4, can be retrieved from the matrix with appropriate coords")
    @Test
    void test_getSquareAt_5_4() {
        ChessSquare square = new ChessSquare(5, 4);
        chessBoardMatrix.addSquareToBoardMatrix(square);
        ChessSquare resultSquare = chessBoardMatrix.getSquareAtCoords(5, 4);
        assertEquals(square, resultSquare);
    }

    @Tag("GetSquareCoordinateTest")
    @DisplayName("Ensure a Square at 3, 4, returns proper matrix coordinates")
    @Test
    void test_getMatrixCoordinatesOfSquareAt_3_4() {
        ChessSquare square = new ChessSquare(3, 4);
        List<Integer> squareCoordinates = chessBoardMatrix.getSquarePositionInMatrix(square);
        assertEquals(3, squareCoordinates.get(ChessBoardMatrix.ROW_INDEX_OF_COORDINATE_ARRAY));
        assertEquals(4, squareCoordinates.get(ChessBoardMatrix.COL_INDEX_OF_COORDINATE_ARRAY));
    }

    /*
    @Nested
    @Tag("GetCoordinatesBasedOnInputCoordinate")
    @DisplayName("Test the methods for getting coordinates based on an input coordinate")
    class CoordinateTests {

        @Tag("GetCoordinatesInSameColTest")
        @DisplayName("Ensure all coordinates in the same column as the input Square are returned")
        @Test
        void test_getAllColumnsOfSquareAt_5_0() {
            ChessSquare square = new ChessSquare(6, 1);
            List<BoardCoordinate> resultList = chessBoardMatrix.getUnoccupiedCoordinatesInSameCol(square);
            int expectedResultSize = 7;
            int actualResultSize = resultList.size();
            assertEquals(expectedResultSize, actualResultSize);
            //assertFalse();
        }
    }

     */
}