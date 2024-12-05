package problems._97_InterleavingString;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) return false;
        // 动态规划，dp[i,j]表示s1前i字符能与s2前j字符组成s3前i+j个字符；
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= m && s1.charAt(i-1) == s3.charAt(i-1); i++) dp[i][0] = true; // 不相符直接终止
        for (int j = 1; j <= n && s2.charAt(j-1) == s3.charAt(j-1); j++) dp[0][j] = true; // 不相符直接终止
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                    || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        InterleavingString solution = new InterleavingString();
        
        // Test Case 1: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        System.out.println("Test Case 1:");
        System.out.println("Input: s1 = \"aabcc\", s2 = \"dbbca\", s3 = \"aadbbcbcac\"");
        System.out.println("Output: " + solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        // Expected Output: true
        
        // Test Case 2: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
        System.out.println("\nTest Case 2:");
        System.out.println("Input: s1 = \"aabcc\", s2 = \"dbbca\", s3 = \"aadbbbaccc\"");
        System.out.println("Output: " + solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        // Expected Output: false
        
        // Test Case 3: s1 = "", s2 = "", s3 = ""
        System.out.println("\nTest Case 3:");
        System.out.println("Input: s1 = \"\", s2 = \"\", s3 = \"\"");
        System.out.println("Output: " + solution.isInterleave("", "", ""));
        // Expected Output: true
    }
} 