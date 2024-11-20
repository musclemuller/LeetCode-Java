package problems._36_ValidSudoku;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!check(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean check(char[][] board, int r, int c, char t) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == t && i != r) {
                return false;
            }

            if (board[r][i] == t && i != c) {
                return false;
            }

            int x = (r / 3) * 3 + (i % 3);
            int y = (c / 3) * 3 + (i / 3);
            if (board[x][y] == t && (x != r || y != c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku s = new ValidSudoku();
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

        System.out.println(s.isValidSudoku(board));
    }
}
