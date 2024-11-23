package problems._51_NQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> res;
    List<String> board;


    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        backtrack(0);
        return res;
    }

    private void backtrack(int row) {
        if (row >= board.size()) {
            res.add(new ArrayList<>(board));
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
        NQueens solution = new NQueens();
        
        // Test case 1: n = 4
        System.out.println("Test case 1 (n = 4):");
        List<List<String>> result1 = solution.solveNQueens(4);
        System.out.println("Number of solutions: " + result1.size());
        for (List<String> board : result1) {
            System.out.println("Solution:");
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println(); // Empty line between solutions
        }
        
        // Test case 2: n = 1
        System.out.println("Test case 2 (n = 1):");
        List<List<String>> result2 = solution.solveNQueens(1);
        System.out.println("Number of solutions: " + result2.size());
        for (List<String> board : result2) {
            System.out.println("Solution:");
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
        
        // Optional: Additional test case for n = 8
        System.out.println("Test case 3 (n = 8):");
        List<List<String>> result3 = solution.solveNQueens(8);
        System.out.println("Number of solutions: " + result3.size());
        // Due to large number of solutions for n=8, maybe just print first few
        int maxSolutionsToPrint = 3;
        for (int i = 0; i < Math.min(maxSolutionsToPrint, result3.size()); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            List<String> board = result3.get(i);
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
        if (result3.size() > maxSolutionsToPrint) {
            System.out.println("... and " + (result3.size() - maxSolutionsToPrint) + 
                             " more solutions");
        }
    }
}
