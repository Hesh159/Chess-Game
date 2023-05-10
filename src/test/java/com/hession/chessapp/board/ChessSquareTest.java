package com.hession.chessapp.board;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ChessSquareTest {

    static ChessSquare chessSquare;

    @BeforeAll
    static void setup() {
        chessSquare = new ChessSquare(0, 0);
    }

    @Nested
    @Tag("SquareIDTests")
    @DisplayName("Ensure ChessSquare coordinates and ID are set appropriately")
    class SquareIDTests {
        @Tag("LetterCoordinateTests")
        @DisplayName("Ensure setting ChessSquare column to 0 returns a letter coordinate of 'a'")
        @Test
        void givenColOf0_TestSquareLetterCoordEquals_a() {
            chessSquare.setCol(0);
            char expectedLetterCoord = 'a';
            assertEquals(expectedLetterCoord, chessSquare.getLetterCoordinate());
        }

        @Tag("LetterCoordinateTests")
        @DisplayName("Ensure setting ChessSquare column to 7 returns a letter coordinate of 'h'")
        @Test
        void givenColOf7_TestSquareLetterCoordEquals_h() {
            chessSquare.setCol(7);
            char expectedLetterCoord = 'h';
            assertEquals(expectedLetterCoord, chessSquare.getLetterCoordinate());
        }

        @Tag("NumberCoordinateTests")
        @DisplayName("Ensure setting ChessSquare row to 0 returns a number coordinate of 8")
        @Test
        void givenRowOf0_TestSquareNumberCoordEquals_8() {
            chessSquare.setRow(0);
            int expectedNumberCoord = 8;
            assertEquals(expectedNumberCoord, chessSquare.getNumberCoordinate());
        }

        @Tag("NumberCoordinateTests")
        @DisplayName("Ensure setting ChessSquare row to 7 returns a number coordinate of 1")
        @Test
        void givenRowOf7_TestSquareNumberCoordEquals_1() {
            chessSquare.setRow(7);
            int expectedNumberCoord = 1;
            assertEquals(expectedNumberCoord, chessSquare.getNumberCoordinate());
        }

        @Tag("IdTests")
        @DisplayName("Ensure setting ChessSquare row to 5, and col to 7 returns an id of h3")
        @Test
        void givenRowOf5AndColOf7_TestSquareIdEquals_h3() {
            chessSquare.setRow(5);
            chessSquare.setCol(7);
            chessSquare.createAndSetId();
            String expectedId = "h3";
            assertEquals(expectedId, chessSquare.getId());
        }
    }

    @Nested
    @Tag("SquareColorTests")
    @DisplayName("Ensure appropriate color is being set on ChessSquare")
    class SquareColorTests {

        @Tag("SquareDarkTest")
        @DisplayName("Ensure Square is correctly being set to dark")
        @Test
        void testSquareIsCorrectlySetToDark() {
            chessSquare.setRow(7);
            chessSquare.setCol(2);
            chessSquare.setSquareColor();
            assertEquals(ChessSquare.DARK, chessSquare.getFill());
        }

        @Tag("SquareLightTest")
        @DisplayName("Ensure Square is correctly being set to light")
        @Test
        void testSquareIsCorrectlySetToLight() {
            chessSquare.setRow(3);
            chessSquare.setCol(1);
            chessSquare.setSquareColor();
            assertEquals(ChessSquare.LIGHT, chessSquare.getFill());
        }
    }
}
