package problems._63_UniquePathsII;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        for(int i = 1; i < n; ++i) {
            if(obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        for(int j = 1; j < m; ++j) {
            if(obstacleGrid[0][j] == 1 || dp[0][j - 1] == 0) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }

        for(int i = 1; i < n; ++i) {
            for(int j = 1; j < m; ++j) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        UniquePathsII solution = new UniquePathsII();
        int[][] obstacleGrid1 = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid1)); // Output: 2

        int[][] obstacleGrid2 = {
            {0, 1},
            {0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid2)); // Output: 1
    }
} 