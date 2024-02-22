package com.company;

public class sudokuSolver {
    public boolean isSafe(char[][] board, int row, int col, int number) {
        // Check if the number is already present in the column
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == (char)(number + '0')) {
                return false; // If found, it's not safe
            }
        }

        // Check if the number is already present in the row
        for(int j = 0; j < board.length; j++) {
            if(board[row][j] == (char)(number + '0')) {
                return false; // If found, it's not safe
            }
        }

        // Find the starting point of the 3x3 grid
        int sr = 3 * (row / 3);
        int sc = 3 * (col / 3);

        // Check if the number is already present in the 3x3 grid
        for(int i = sr; i < sr + 3; i++) {
            for(int j = sc; j < sc + 3; j++) {
                if(board[i][j] == (char)(number + '0')) {
                    return false; // If found, it's not safe
                }
            }
        }

        return true; // If the number is not found in column, row, or grid, it's safe
    }

    public boolean helper(char[][] board, int row, int col) {
        // Base case: If we've reached beyond the last row, Sudoku is solved
        if(row == board.length) {
            return true;
        }

        int nrow = 0;
        int ncol = 0;

        // Determine the next row and column indices
        if(col == board.length - 1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        // If the current cell is not empty, proceed to the next cell
        if(board[row][col] != '.') {
            if(helper(board, nrow, ncol)) {
                return true; // If the next cell is successfully filled, return true
            }
        } else {
            // Fill the current cell with a valid number
            for(int i = 1; i <= 9; i++) {
                if(isSafe(board, row, col, i)) {
                    board[row][col] = (char)(i + '0');
                    // Proceed to the next cell recursively
                    if(helper(board, nrow, ncol))
                        return true; // If Sudoku is solved, return true
                    else
                        board[row][col] = '.'; // Backtrack if Sudoku cannot be solved
                }
            }
        }

        return false; // If no valid number can be placed in the current cell, return false
    }

    public void solveSudoku(char[][] board) {
        // Start solving Sudoku from the top-left cell
        helper(board, 0, 0);
    }

}




