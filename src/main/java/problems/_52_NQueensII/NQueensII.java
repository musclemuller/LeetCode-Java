package problems._52_NQueensII;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    int count;
    List<String> board;


public int totalNQueens(int n) {
        count = 0;
        board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        backtrack(0);
        return count;
    }

    private void backtrack(int row) {
        if (row >= board.size()) {
            count++;
            return;
        }

        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            if (!isValid(col, row)) {
                continue;
            }

            char[] rowChars = board.get(row).toCharArray();
            rowChars[col] = 'Q';
            board.set(row, new String(rowChars));

            backtrack(row + 1);

            rowChars[col] = '.';
            board.set(row, new String(rowChars));
        }
    }

    boolean isValid(int col, int row) {
        int n = board.size();

        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensII s = new NQueensII(); // 假设你的类名是TotalNQueens
        
        // Test case 1: n = 4
        System.out.println("Test case 1 (n = 4):");
        int result1 = s.totalNQueens(4);
        System.out.println("Number of distinct solutions: " + result1);
        System.out.println("Expected: 2");
        System.out.println("Test case 1 " + (result1 == 2 ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 2: n = 1
        System.out.println("Test case 2 (n = 1):");
        int result2 = s.totalNQueens(1);
        System.out.println("Number of distinct solutions: " + result2);
        System.out.println("Expected: 1");
        System.out.println("Test case 2 " + (result2 == 1 ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Additional test cases
        // n = 8 is a classic case for 8-queens puzzle
        System.out.println("Additional test case (n = 8):");
        int result3 = s.totalNQueens(8);
        System.out.println("Number of distinct solutions: " + result3);
        System.out.println("Expected: 92");
        System.out.println("Additional test case " + (result3 == 92 ? "PASSED" : "FAILED"));
    }
}
