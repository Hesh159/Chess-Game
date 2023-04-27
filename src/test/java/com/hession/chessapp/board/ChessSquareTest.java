package com.hession.chessapp.board;

import org.junit.jupiter.api.*;

import java.security.cert.CertSelector;

import static org.junit.jupiter.api.Assertions.*;

class ChessSquareTest {

    static ChessSquare chessSquare;

    @BeforeAll
    static void setup() {
        chessSquare = new ChessSquare();
    }

    @Nested
    @Tag("SquareIDTests")
    @DisplayName("Ensure ChessSquare coordinates and ID are set appropriately")
    class SquareIDTests {
        @Tag("LetterCoordinateTests")
        @DisplayName("Ensure setting ChessSquare column to 1 returns a letter coordinate of 'a'")
        @Test
        void givenColOf1_TestSquareLetterCoordEquals_a() {
            chessSquare.setCol(1);
            char expectedLetterCoord = 'a';
            assertEquals(expectedLetterCoord, chessSquare.getLetterCoordinate());
        }

        @Tag("LetterCoordinateTests")
        @DisplayName("Ensure setting ChessSquare column to 8 returns a letter coordinate of 'h'")
        @Test
        void givenColOf8_TestSquareLetterCoordEquals_h() {
            chessSquare.setCol(8);
            char expectedLetterCoord = 'h';
            assertEquals(expectedLetterCoord, chessSquare.getLetterCoordinate());
        }

        @Tag("NumberCoordinateTests")
        @DisplayName("Ensure setting ChessSquare row to 1 returns a number coordinate of 8")
        @Test
        void givenRowOf1_TestSquareNumberCoordEquals_8() {
            chessSquare.setRow(8);
            int expectedNumberCoord = 1;
            assertEquals(expectedNumberCoord, chessSquare.getNumberCoordinate());
        }

        @Tag("NumberCoordinateTests")
        @DisplayName("Ensure setting ChessSquare row to 8 returns a number coordinate of 1")
        @Test
        void givenRowOf8_TestSquareNumberCoordEquals_1() {
            chessSquare.setRow(1);
            int expectedNumberCoord = 8;
            assertEquals(expectedNumberCoord, chessSquare.getNumberCoordinate());
        }

        @Tag("IdTests")
        @DisplayName("Ensure setting ChessSquare row to 6, and col to 8 returns an id of h3")
        @Test
        void givenRowOf6AndColOf8_TestSquareIdEquals_h3() {
            chessSquare.setRow(6);
            chessSquare.setCol(8);
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
            chessSquare.setRow(8);
            chessSquare.setCol(3);
            chessSquare.setSquareColor();
            assertEquals(ChessSquare.DARK, chessSquare.getFill());
        }

        @Tag("SquareLightTest")
        @DisplayName("Ensure Square is correctly being set to light")
        @Test
        void testSquareIsCorrectlySetToLight() {
            chessSquare.setRow(4);
            chessSquare.setCol(2);
            chessSquare.setSquareColor();
            assertEquals(ChessSquare.LIGHT, chessSquare.getFill());
        }
    }
}
