package com.example.sudoku.models;

public class SudokuModel {
    int[][] sudoku = new int[6][6];

    public int getSudoku(int row, int col) {
        return sudoku[row][col];
    }
    public void setSudoku(int row, int col, int value) {
        this.sudoku[row][col] = value;
    }

}
