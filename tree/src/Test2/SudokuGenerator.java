package Test2;

import java.util.Random;

public class SudokuGenerator {
    private static final int SIZE = 9;
    private static final int SUBGRID_SIZE = 3;
    private int[][] board;

    public SudokuGenerator() {
        board = new int[SIZE][SIZE];
        generateSudoku();
    }

    private void generateSudoku() {
        fillDiagonal();
        fillRemaining(0, 3);
    }

    private void fillDiagonal() {
        for (int i = 0; i < SIZE; i += SUBGRID_SIZE) {
            fillSubgrid(i, i);
        }
    }

    private void fillSubgrid(int row, int col) {
        Random rand = new Random();
        boolean[] used = new boolean[SIZE + 1];
        for (int i = 0; i < SUBGRID_SIZE; i++) {
            for (int j = 0; j < SUBGRID_SIZE; j++) {
                int num;
                do {
                    num = rand.nextInt(SIZE) + 1;
                } while (used[num]);
                used[num] = true;
                board[row + i][col + j] = num;
            }
        }
    }

    private boolean fillRemaining(int row, int col) {
        if (row >= SIZE - 1 && col >= SIZE) {
            return true;
        }
        if (col >= SIZE) {
            row++;
            col = 0;
        }
        if (board[row][col] != 0) {
            return fillRemaining(row, col + 1);
        }
        for (int num = 1; num <= SIZE; num++) {
            if (isSafe(row, col, num)) {
                board[row][col] = num;
                if (fillRemaining(row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col, int num) {
        return !usedInRow(row, num) && !usedInCol(col, num) && !usedInSubgrid(row - row % SUBGRID_SIZE, col - col % SUBGRID_SIZE, num);
    }

    private boolean usedInRow(int row, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInCol(int col, int num) {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInSubgrid(int startRow, int startCol, int num) {
        for (int row = 0; row < SUBGRID_SIZE; row++) {
            for (int col = 0; col < SUBGRID_SIZE; col++) {
                if (board[row + startRow][col + startCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] getBoard() {
        return board;
    }
}

