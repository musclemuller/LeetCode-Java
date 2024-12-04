package problems._79_WordSearch;

public class WordSearch {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean found;

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        found = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, word, 0);
            }
        }
        return found;
    }

    void dfs(char[][] board, int i, int j, String word, int index) {
        if (found) return;
        char cur = board[i][j];
        int m = board.length, n = board[0].length;
        if (cur != word.charAt(index)) {
            return;
        }
        if (index == word.length() - 1) {
            found = true;
            return;
        }

        char tmp = board[i][j];
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                continue;
            }
            dfs(board, ni, nj, word, index + 1);
        }
        board[i][j] = tmp;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        // Test Case 1: Basic example with word "ABCCED"
        char[][] board1 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word1 = "ABCCED";
        System.out.println("Input: board = " + java.util.Arrays.deepToString(board1) + ", word = \"" + word1 + "\"");
        System.out.println("Output: " + solution.exist(board1, word1));
        System.out.println("Expected: true");
        System.out.println();

        // Test Case 2: Example with word "SEE"
        char[][] board2 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word2 = "SEE";
        System.out.println("Input: board = " + java.util.Arrays.deepToString(board2) + ", word = \"" + word2 + "\"");
        System.out.println("Output: " + solution.exist(board2, word2));
        System.out.println("Expected: true");
        System.out.println();

        // Test Case 3: Example with word "ABCB" (should return false)
        char[][] board3 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word3 = "ABCB";
        System.out.println("Input: board = " + java.util.Arrays.deepToString(board3) + ", word = \"" + word3 + "\"");
        System.out.println("Output: " + solution.exist(board3, word3));
        System.out.println("Expected: false");
        System.out.println();
    }
} 
