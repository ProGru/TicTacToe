package com.adam.Tests;

import com.adam.TicTacToeMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicTacToeMapTest {
    TicTacToeMap ticTacToeMap;

    @Test
    void placeCross() {
        ticTacToeMap = new TicTacToeMap();
        ticTacToeMap.placeCross(2,2);
        assertEquals('X',ticTacToeMap.getItemInPosition(2,2));
    }

    @Test
    void placeCircle() {
        ticTacToeMap = new TicTacToeMap();
        ticTacToeMap.placeCircle(2,2);
        assertEquals('O',ticTacToeMap.getItemInPosition(2,2));
    }

    @Test
    void mapSize() {
        ticTacToeMap = new TicTacToeMap();
        assertEquals(9, ticTacToeMap.getMap().length);
    }

    @Test
    void getItemPosition() {
        ticTacToeMap = new TicTacToeMap();
        assertEquals('.', ticTacToeMap.getItemInPosition(2,2));
    }

    @Test
    void checkForWiner() {
        ticTacToeMap = new TicTacToeMap();
        ticTacToeMap.placeCircle(0,0);
        ticTacToeMap.placeCircle(0,1);
        ticTacToeMap.placeCircle(0,2);
        assertEquals('O',ticTacToeMap.checkForWiner());
        ticTacToeMap = new TicTacToeMap();
        ticTacToeMap.placeCircle(0,0);
        ticTacToeMap.placeCircle(1,1);
        ticTacToeMap.placeCircle(2,2);
        assertEquals('O',ticTacToeMap.checkForWiner());
        ticTacToeMap = new TicTacToeMap();
        ticTacToeMap.placeCircle(0,0);
        ticTacToeMap.placeCircle(1,0);
        ticTacToeMap.placeCircle(2,0);
        assertEquals('O',ticTacToeMap.checkForWiner());
        ticTacToeMap = new TicTacToeMap();
        ticTacToeMap.placeCircle(0,0);
        ticTacToeMap.placeCircle(1,0);
        ticTacToeMap.placeCross(2,0);

        ticTacToeMap.placeCross(0,1);
        ticTacToeMap.placeCross(1,1);
        ticTacToeMap.placeCircle(2,1);

        ticTacToeMap.placeCircle(0,2);
        ticTacToeMap.placeCross(1,2);
        ticTacToeMap.placeCircle(2,2);
        assertEquals('R',ticTacToeMap.checkForWiner());

    }
}