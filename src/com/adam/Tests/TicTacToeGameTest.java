package com.adam.Tests;

import com.adam.TicTacToeGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {

    TicTacToeGame ticTacToeGame;



    @Test
    void showMap() {
        ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.showMap();
    }

    @Test
    void isUserInputCorrect() {
        ticTacToeGame = new TicTacToeGame();
        assertTrue(ticTacToeGame.isUserInputCorrect("A1"));
        assertFalse(ticTacToeGame.isUserInputCorrect("A4"));
        assertFalse(ticTacToeGame.isUserInputCorrect("D1"));
    }

    @Test
    void userInputParser() throws Exception {
        ticTacToeGame = new TicTacToeGame();
        int[] parseInput = ticTacToeGame.userInputParser("A1");
        assertEquals(0,parseInput[0]);
        assertEquals(0,parseInput[1]);

    }

    @Test
    void isSomeoneWin() {
        ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.ticTacToeMap.placeCircle(0,0);
        ticTacToeGame.ticTacToeMap.placeCircle(1,0);
        ticTacToeGame.ticTacToeMap.placeCircle(2,0);
        assertTrue(ticTacToeGame.isSomeoneWin());

    }

}