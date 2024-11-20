package problems._48_RotateImage;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int[] row : matrix) {
            reverse(row);
        }
    }
    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        RotateImage s = new RotateImage();
        int[][] matrix1 = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };
        s.rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        int[][] matrix2 = new int[][]{
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16},
        };
        s.rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }
}
