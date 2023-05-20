package com.hession.chessapp.board;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessBoardMatrixTest {

    static ChessBoardMatrix chessBoardMatrix;
    static ChessBoard chessBoard;

    @BeforeAll
    static void setup() {
        chessBoard = new ChessBoard();
        chessBoardMatrix = chessBoard.getChessBoardMatrix();
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

    @Nested
    @Tag("GetCoordinatesBasedOnInputCoordinate")
    @DisplayName("Test the methods for getting coordinates based on an input coordinate")
    class CoordinateTests {

        @Tag("GetCoordinatesInSameRowTest")
        @DisplayName("Ensure all coordinates in the same row as the input Square are returned")
        @Test
        void test_getAllColumnsOfSquareAtRow_5() {
            ChessSquare square = new ChessSquare(5, 0);
            List<ChessSquare> resultList = chessBoardMatrix.getUnoccupiedSquaresInSameRow(square);
            int expectedResultSize = 7;
            assertThat(resultList).hasSize(expectedResultSize).contains(new ChessSquare(5, 1))
                    .contains(new ChessSquare(5, 7))
                    .doesNotContain(new ChessSquare(5, 0));
        }

        @Tag("GetCoordinatesInSameRowTest")
        @DisplayName("Ensure getting coordinates in the same row as the input square searches forwards and backwards")
        @Test
        void givenInputSquare_whenGetUnoccupiedSquaresInSameRow_thenReturnAll() {
            ChessSquare square = new ChessSquare(7, 4);
            List<ChessSquare> resultList = chessBoardMatrix.getUnoccupiedSquaresInSameRow(square);
            int expectedResultSize = 7;
            assertThat(resultList).hasSize(expectedResultSize).contains(new ChessSquare(7, 3))
                    .contains(new ChessSquare(7, 5)).doesNotContain(new ChessSquare(7, 4));
        }

        @Tag("GetCoordinatesInSameRowTest")
        @DisplayName("Test getUnoccupiedSquaresInSameRow doesn't add occupied squares")
        @Test
        void givenSquare_whenSquaresInRowAreOccupied_thenDontAddToResultList() {
            ChessSquare square = new ChessSquare(4, 3);
            chessBoardMatrix.setSquareOccupiedStatusAtCoords(4, 1, true);
            chessBoardMatrix.setSquareOccupiedStatusAtCoords(4, 6, true);
            List<ChessSquare> resultList = chessBoardMatrix.getUnoccupiedSquaresInSameRow(square);
            int expectedResultSize = 3;
            System.out.println(resultList);
            assertThat(resultList).hasSize(expectedResultSize)
                    .contains(new ChessSquare(4, 2))
                    .contains(new ChessSquare(4, 5))
                    .doesNotContain(new ChessSquare(4, 1))
                    .doesNotContain(new ChessSquare(4, 7));
        }

        @Tag("GetCoordinatesInSameColTest")
        @DisplayName("getUnoccupiedSquaresInSameCol test all values in same col are returned")
        @Test
        void givenSquare_whenNoSquaresOccupied_thenReturnWholeCol() {
            ChessSquare square = new ChessSquare(6, 6);
            List<ChessSquare> squaresFound = chessBoardMatrix.getUnoccupiedSquaresInSameCol(square);
            int expectedResultSize = 7;
            assertThat(squaresFound).hasSize(expectedResultSize)
                    .contains(new ChessSquare(7, 6))
                    .contains(new ChessSquare(5, 6))
                    .contains(new ChessSquare(0, 6))
                    .doesNotContain(new ChessSquare(6, 6));
        }

        @Tag("GetCoordinatesInSameColTest")
        @DisplayName("getUnoccupiedSquaresInSameCol test no values returned if squares on either side are occupied")
        @Test
        void givenSquare_whenSurroundedByOccupiedSquares_thenReturnEmptyList() {
            ChessSquare square = new ChessSquare( 3, 5);
            chessBoardMatrix.setSquareOccupiedStatusAtCoords(2, 5, true);
            chessBoardMatrix.setSquareOccupiedStatusAtCoords(4, 5, true);
            List<ChessSquare> squaresFound = chessBoardMatrix.getUnoccupiedSquaresInSameCol(square);
            assertThat(squaresFound).isEmpty();
        }
    }
}