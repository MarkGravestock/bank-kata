package com.softwareraftmanship.Board;

public class Column {
    public static final int MAXIMUM_NUMBER_OF_ROWS = 7;
    private int count;

    public boolean placeToken() {
        count++;
        return count < MAXIMUM_NUMBER_OF_ROWS;
    }

    public boolean hasTokenAt(int row) {
        return  row < count;
    }
}
