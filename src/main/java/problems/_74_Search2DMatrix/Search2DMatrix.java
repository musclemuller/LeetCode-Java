package problems._74_Search2DMatrix;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = get(matrix, mid);
            if (val == target) {
                return true;
            } else if (val < target) {
                l = mid + 1;
            } else if (val > target) {
                r = mid - 1;
            }
        }
        return false;
    }

    int get(int[][] matrix, int index) {
        int n = matrix[0].length;
        int i = index / n, j = index % n;
        return matrix[i][j];
    }

    public static void main(String[] args) {
        Search2DMatrix solution = new Search2DMatrix();

        // Test Case 1: Basic example with target present
        int[][] matrix1 = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target1 = 3;
        System.out.println("Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3");
        System.out.println("Output: " + solution.searchMatrix(matrix1, target1));
        System.out.println("Expected: true");
        System.out.println();

        // Test Case 2: Target not present in matrix
        int[][] matrix2 = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target2 = 13;
        System.out.println("Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13");
        System.out.println("Output: " + solution.searchMatrix(matrix2, target2));
        System.out.println("Expected: false");
        System.out.println();
    }
} 