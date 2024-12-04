package problems._70_ClimbingStairs;

public class ClimbingStairs {
    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n + 1];
        f(n);
        return dp[n];
    }

    int f(int n) {
        if (n == 1) {
            dp[n] = 1;
            return 1;
        }
        if (n == 2) {
            dp[n] = 2;
            return 2;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = f(n - 1) + f(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        
        // Test case 1
        int n1 = 2;
        System.out.println("Test case 1:");
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + solution.climbStairs(n1));
        System.out.println("Explanation: There are two ways to climb to the top.");
        System.out.println("1. 1 step + 1 step");
        System.out.println("2. 2 steps");
        
        // Test case 2
        int n2 = 3;
        System.out.println("\nTest case 2:");
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + solution.climbStairs(n2));
        System.out.println("Explanation: There are three ways to climb to the top.");
        System.out.println("1. 1 step + 1 step + 1 step");
        System.out.println("2. 1 step + 2 steps");
        System.out.println("3. 2 steps + 1 step");
    }
} 