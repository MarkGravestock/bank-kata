package com.softwareraftmanship.Board;

public class Game {
    int count = 0;

    public void playTokenInColumn(int column, Colour red) {
        count++;
    }

    public boolean hasWinner(Colour red) {
        return count > 3;
    }
}
