package problems._72_EditDistance;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                        dp[i - 1][j] + 1,

                        dp[i][j - 1] + 1,

                        dp[i - 1][j - 1] + 1

                    );
                }
            }
        }

        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();

        // Test Case 1: Basic example with different operations
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("Input: word1 = \"" + word1 + "\", word2 = \"" + word2 + "\"");
        System.out.println("Output: " + solution.minDistance(word1, word2));
        System.out.println("Expected: 3");
        System.out.println("Explanation:");
        System.out.println("horse -> rorse (replace 'h' with 'r')");
        System.out.println("rorse -> rose (remove 'r')");
        System.out.println("rose -> ros (remove 'e')");
        System.out.println();

        // Test Case 2: More complex example
        word1 = "intention";
        word2 = "execution";
        System.out.println("Input: word1 = \"" + word1 + "\", word2 = \"" + word2 + "\"");
        System.out.println("Output: " + solution.minDistance(word1, word2));
        System.out.println("Expected: 5");
        System.out.println("Explanation:");
        System.out.println("intention -> inention (remove 't')");
        System.out.println("inention -> enention (replace 'i' with 'e')");
        System.out.println("enention -> exention (replace 'n' with 'x')");
        System.out.println("exention -> exection (replace 'n' with 'c')");
        System.out.println("exection -> execution (insert 'u')");
        System.out.println();
    }
} 
