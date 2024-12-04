package problems._62_UniquePaths;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        
        // Test case 1: m = 3, n = 7
        System.out.println("Test case 1: m = 3, n = 7");
        System.out.println("Expected: 28");
        System.out.println("Actual: " + solution.uniquePaths(3, 7));
        System.out.println();
        
        // Test case 2: m = 3, n = 2
        System.out.println("Test case 2: m = 3, n = 2");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + solution.uniquePaths(3, 2));
        System.out.println();
    }

} 