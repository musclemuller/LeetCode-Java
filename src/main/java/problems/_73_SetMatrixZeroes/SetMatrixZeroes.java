package problems._73_SetMatrixZeroes;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();

        // Test Case 1: Basic example with one zero
        int[][] matrix1 = {{1,1,1}, {1,0,1}, {1,1,1}};
        System.out.println("Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]");
        solution.setZeroes(matrix1);
        System.out.println("Output: [[1,0,1],[0,0,0],[1,0,1]]");
        System.out.println();

        // Test Case 2: Example with multiple zeros
        int[][] matrix2 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        System.out.println("Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
        solution.setZeroes(matrix2);
        System.out.println("Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]");
        System.out.println();
    }
} 