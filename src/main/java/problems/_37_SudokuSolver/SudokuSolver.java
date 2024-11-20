package problems._37_SudokuSolver;

import java.util.Arrays;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            return true;
        }
        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, i, j, ch)) {
                continue;
            }

            board[i][j] = ch;
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }

        return false;
    }

    boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == n) return false;
            if (board[i][c] == n) return false;
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        s.solveSudoku(board);
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
