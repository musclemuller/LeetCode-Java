package problems._59_SpiralMatrixII;

import java.util.Arrays;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upper_bound = 0, lower_bound = n - 1;
        int left_bound = 0, right_bound = n - 1;
        // 需要填入矩阵的数字
        int num = 1;
        
        while (num <= n * n) {
            if (upper_bound <= lower_bound) {
                // 在顶部从左向右遍历
                for (int j = left_bound; j <= right_bound; j++) {
                    matrix[upper_bound][j] = num++;
                }
                // 上边界下移
                upper_bound++;
            }
            
            if (left_bound <= right_bound) {
                // 在右侧从上向下遍历
                for (int i = upper_bound; i <= lower_bound; i++) {
                    matrix[i][right_bound] = num++;
                }
                // 右边界左移
                right_bound--;
            }
            
            if (upper_bound <= lower_bound) {
                // 在底部从右向左遍历
                for (int j = right_bound; j >= left_bound; j--) {
                    matrix[lower_bound][j] = num++;
                }
                // 下边界上移
                lower_bound--;
            }
            
            if (left_bound <= right_bound) {
                // 在左侧从下向上遍历
                for (int i = lower_bound; i >= upper_bound; i--) {
                    matrix[i][left_bound] = num++;
                }
                // 左边界右移
                left_bound++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII solution = new SpiralMatrixII();
        
        // Test case 1: n = 3
        System.out.println("Test case 1:");
        int n1 = 3;
        System.out.println("Input: n = " + n1);
        int[][] result1 = solution.generateMatrix(n1);
        System.out.println("Output: " + Arrays.deepToString(result1));
        int[][] expected1 = new int[][]{{1,2,3}, {8,9,4}, {7,6,5}};
        System.out.println("Expected: " + Arrays.deepToString(expected1));
        System.out.println("Test case 1 " + (Arrays.deepEquals(result1, expected1) ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 2: n = 1
        System.out.println("Test case 2:");
        int n2 = 1;
        System.out.println("Input: n = " + n2);
        int[][] result2 = solution.generateMatrix(n2);
        int[][] expected2 = new int[][]{{1}};
        System.out.println("Output: " + Arrays.deepToString(result2));
        System.out.println("Expected: " + Arrays.deepToString(expected2));
        System.out.println("Test case 2 " + (Arrays.deepEquals(result2, expected2) ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 3: n = 4
        System.out.println("Test case 3:");
        int n3 = 4;
        System.out.println("Input: n = " + n3);
        int[][] result3 = solution.generateMatrix(n3);
        int[][] expected3 = new int[][]{
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
        };
        System.out.println("Output: " + Arrays.deepToString(result3));
        System.out.println("Expected: " + Arrays.deepToString(expected3));
        System.out.println("Test case 3 " + (Arrays.deepEquals(result3, expected3) ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 4: n = 2
        System.out.println("Test case 4:");
        int n4 = 2;
        System.out.println("Input: n = " + n4);
        int[][] result4 = solution.generateMatrix(n4);
        int[][] expected4 = new int[][]{{1,2}, {4,3}};
        System.out.println("Output: " + Arrays.deepToString(result4));
        System.out.println("Expected: " + Arrays.deepToString(expected4));
        System.out.println("Test case 4 " + (Arrays.deepEquals(result4, expected4) ? "PASSED" : "FAILED"));
    }
}
