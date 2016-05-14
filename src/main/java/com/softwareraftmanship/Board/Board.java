package com.softwareraftmanship.Board;

public class Board {
    private Column[] columns;

    public Board() {
        int numberOfColums = 7;
        columns = new Column[numberOfColums];

        for (int i = 0; i < numberOfColums; i++){
            columns[i] = new Column();
        }
    }

    public void placeTokenAt(int columnIndex) {

        if(columnIndex > columns.length)
        {
            throw new IndexOutOfBoundsException();
        }
        columns[columnIndex].placeToken();
    }

    public boolean hasTokenAt(int columnIndex, int rowIndex) {
        return columns[columnIndex].hasTokenAt(rowIndex);
    }
}
