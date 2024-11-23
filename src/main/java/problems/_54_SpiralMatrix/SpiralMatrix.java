package problems._54_SpiralMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Helper.Printer;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upBound = 0, lowBound = m - 1;
        int leftBound = 0, rightBound = n - 1;
        List<Integer> res = new ArrayList<>();
        while (res.size() < m * n) {
            if (upBound <= lowBound) {
                for (int j = leftBound; j <= rightBound; j++) {
                    res.add(matrix[upBound][j]);
                }
                upBound++;
            }

            if (leftBound <= rightBound) {
                for (int i = upBound; i <= lowBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }

            if (upBound <= lowBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    res.add(matrix[lowBound][j]);
                }
                lowBound--;
            }

            if (leftBound <= rightBound) {
                for (int i = lowBound; i >= upBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        
        // Test case 1: 3x3 matrix
        System.out.println("Test case 1 (3x3 matrix):");
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result1 = s.spiralOrder(matrix1);
        System.out.println("Input: matrix = " + Printer.matrixToString(matrix1));
        System.out.println("Output: " + result1);
        System.out.println("Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]");
        System.out.println("Test case 1 " + 
            (result1.toString().equals("[1, 2, 3, 6, 9, 8, 7, 4, 5]") ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 2: 3x4 matrix
        System.out.println("Test case 2 (3x4 matrix):");
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        List<Integer> result2 = s.spiralOrder(matrix2);
        System.out.println("Input: matrix = " + Printer.matrixToString(matrix2));
        System.out.println("Output: " + result2);
        System.out.println("Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]");
        System.out.println("Test case 2 " + 
            (result2.toString().equals("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]") ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 3: 1x1 matrix
        System.out.println("Test case 3 (1x1 matrix):");
        int[][] matrix3 = {{1}};
        List<Integer> result3 = s.spiralOrder(matrix3);
        System.out.println("Input: matrix = " + Printer.matrixToString(matrix3));
        System.out.println("Output: " + result3);
        System.out.println("Expected: [1]");
        System.out.println("Test case 3 " + 
            (result3.toString().equals("[1]") ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 4: 1x3 matrix
        System.out.println("Test case 4 (1x3 matrix):");
        int[][] matrix4 = {{1, 2, 3}};
        List<Integer> result4 = s.spiralOrder(matrix4);
        System.out.println("Input: matrix = " + Printer.matrixToString(matrix4));
        System.out.println("Output: " + result4);
        System.out.println("Expected: [1, 2, 3]");
        System.out.println("Test case 4 " + 
            (result4.toString().equals("[1, 2, 3]") ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 5: 3x1 matrix
        System.out.println("Test case 5 (3x1 matrix):");
        int[][] matrix5 = {{1}, {2}, {3}};
        List<Integer> result5 = s.spiralOrder(matrix5);
        System.out.println("Input: matrix = " + Printer.matrixToString(matrix5));
        System.out.println("Output: " + result5);
        System.out.println("Expected: [1, 2, 3]");
        System.out.println("Test case 5 " + 
            (result5.toString().equals("[1, 2, 3]") ? "PASSED" : "FAILED"));
    }
}
